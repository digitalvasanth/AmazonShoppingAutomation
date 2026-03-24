
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    private By searchBox = By.id("twotabsearchtextbox");
    private By productLinks = By.cssSelector("a.a-link-normal.s-no-outline");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void search(String text) {
        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        box.sendKeys(text);
        box.submit();
    }

    public void clickFirstProduct() {
        List<WebElement> products = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(productLinks));
        products.get(0).click();
    }
     public void clickSecondProduct() {
        List<WebElement> products = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(productLinks));
        products.get(1).click();
    }
}