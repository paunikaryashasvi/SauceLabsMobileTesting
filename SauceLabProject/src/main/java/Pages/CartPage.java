package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

     WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartItemName= By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]");
    By cartItemPrice= By.xpath("//android.widget.TextView[@text=\"$29.99\"]");
    By removeButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]");
    By checkoutBtn = AppiumBy.accessibilityId("test-CHECKOUT");
    private By itemsInCart = AppiumBy.accessibilityId("test-Item");


    public void removeBtnClick() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        driver.findElement(removeButton).click();
    }

    public String itemName(){
        return driver.findElement(cartItemName).getText();
    }

    public String itemPrice(){
        return driver.findElement(cartItemPrice).getText();
    }

    public WebElement continueShoppingBtn(){
        return driver.findElement(AppiumBy.accessibilityId("test-CONTINUE SHOPPING"));
    }

    public CheckoutInfoPage clickCheckoutBtn(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(checkoutBtn).click();
        return new CheckoutInfoPage(driver);
    }

    public WebElement checkoutInformationTag(){
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"CHECKOUT: INFORMATION\"]"));
    }

    public String itemsPresent() {

        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(d -> driver.findElement(itemsInCart));
            return "present";
        } catch (org.openqa.selenium.TimeoutException e) {
            return "notPresent";
        }
    }



}
