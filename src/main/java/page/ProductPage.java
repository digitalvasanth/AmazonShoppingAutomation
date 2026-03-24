package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String mainWindow;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.mainWindow = driver.getWindowHandle();
    }

    public void switchToNewTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String tab : tabs) {
            if (!tab.equals(mainWindow)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

    public void closeAndReturn() {
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    public void addToCart() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1️⃣ Click "Add to Cart"
        WebElement addToCartBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button"))
        );
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", addToCartBtn);

        try {
            addToCartBtn.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", addToCartBtn);
        }

        // 2️⃣ Warranty popup — close it using "attach-warranty-close-icon"
        try {
            WebElement closeWarranty = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("attach-warranty-close-icon"))
            );

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", closeWarranty);

            try {
                closeWarranty.click();
            } catch (Exception ex) {
                js.executeScript("arguments[0].click();", closeWarranty);
            }

            // ⭐ WAIT 5 SECONDS AFTER CLOSING THE POPUP ⭐
            Thread.sleep(5000);

        } catch (TimeoutException ignore) {
            // Warranty popup did not appear → ignore
        } catch (InterruptedException ignored) {}

    }

}