package Pages;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    By finishBtn = AppiumBy.accessibilityId("test-FINISH");
    By overviewProductName = By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]");
    By overviewProductPrice = By.xpath("//android.widget.TextView[@text=\"$29.99\"]");

    public void clickFinishBtn(){
        MobileActions obj = new MobileActions(driver);
        obj.scrollDownToSpecificText("FINISH");
        driver.findElement(finishBtn).click();
    }

    public String newItemName(){
        return driver.findElement(overviewProductName).getText();
    }

    public String newItemPrice(){
        return driver.findElement(overviewProductPrice).getText();
    }

    public WebElement checkoutCompleteTag(){
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]"));
    }
}
