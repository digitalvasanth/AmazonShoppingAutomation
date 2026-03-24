package testcases;

import base.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CartPage;
import page.HomePage;
import page.ProductPage;
import java.time.Duration;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("Initializing WebDriver...");
        WebDriver driver = DriverSetup.initDriver();

        try {
            System.out.println("Navigating to Amazon homepage...");
            driver.get("https://www.amazon.in/");

            // Validate if the home page is loaded
            System.out.println("Validating if the home page is loaded...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            if (wait.until(ExpectedConditions.titleContains("Amazon"))) {
                System.out.println("Home page loaded successfully.");
            } else {
                System.err.println("Home page did not load correctly. Exiting test.");
                return;
            }

            HomePage home = new HomePage(driver);
            ProductPage product = new ProductPage(driver);
            CartPage cart = new CartPage(driver);

            // Search for the first product
            System.out.println("Searching for 'Home appliances'...");
            home.search("Home appliances");
            System.out.println("Clicking on the first product...");
            home.clickFirstProduct();

            // Add the first product to the cart
            System.out.println("Switching to new tab for the first product...");
            product.switchToNewTab();
            System.out.println("Adding the first product to the cart...");
            product.addToCart();
            System.out.println("Retrieving the first cart amount...");
            int amount1 = cart.getTotalAmount();
            System.out.println("First Cart Amount: ₹" + amount1);
            System.out.println("Closing the product tab and returning to the main page...");
            product.closeAndReturn();

            // Add another product to the cart
            System.out.println("Clicking on another product...");
            home.clickSecondProduct();
            System.out.println("Switching to new tab for the second product...");
            product.switchToNewTab();
            System.out.println("Adding the second product to the cart...");
            product.addToCart();
            System.out.println("Retrieving the updated total cart amount...");
            int amount2 = cart.getTotalAmount();
            System.out.println("Updated Total Amount: ₹" + amount2);

            // Validate the total amount
            System.out.println("Validating the total amount...");
            if (amount2 >= amount1) {
                System.out.println("Amount is calculated correctly. Total Amount: ₹" + amount2);
            } else {
                System.err.println("Amount calculation incorrect! Expected amount to increase or remain the same.");
            }

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Quitting the WebDriver...");
            DriverSetup.quitDriver();
        }
    }
}