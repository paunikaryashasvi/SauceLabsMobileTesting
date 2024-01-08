package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CheckoutInfoPage {

    WebDriver driver;

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = AppiumBy.accessibilityId("test-First Name");
    By lastName = AppiumBy.accessibilityId("test-Last Name");
    By zipCode = AppiumBy.accessibilityId("test-Zip/Postal Code");
    By continueBtn = AppiumBy.accessibilityId("test-CONTINUE");

    public CheckoutOverviewPage checkoutInformation(String Fname , String Lname , String zCode ){
        driver.findElement(firstName).sendKeys(Fname);
        driver.findElement(lastName).sendKeys(Lname);
        driver.findElement(zipCode).sendKeys(zCode);
        driver.findElement(continueBtn).click();
        return new CheckoutOverviewPage(driver);
    }

    public WebElement checkoutOverviewTag(){
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"CHECKOUT: OVERVIEW\"]"));
    }
}
