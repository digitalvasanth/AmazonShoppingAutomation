package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getTotalAmount() {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    String script =
        "const selectors = [" +
            "'span.a-price.sw-subtotal-amount .a-offscreen'," +
            "'#sw-subtotal .a-offscreen'," +
            "'#sc-subtotal-amount-buybox .a-offscreen'," +
            "'#sc-subtotal-amount-activecart .a-offscreen'," +
            "'div#attach-accessory-cart-total .a-offscreen'," +
            "'span[data-a-color=\"base\"] .a-offscreen'" +
        "];" +

        "for (let sel of selectors) {" +
        "   const el = document.querySelector(sel);" +
        "   if (el) return el.innerText;" +
        "}" +
        "return null;";

    String amountText = (String) js.executeScript(script);

    if (amountText == null) {
        throw new IllegalStateException("Unable to locate the cart subtotal using JS.");
    }

    amountText = amountText
            .replace("₹", "")
            .replace("INR", "")
            .replace(",", "")
            .trim();

    return (int) Double.parseDouble(amountText);
}

}