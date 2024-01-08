package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameInput = AppiumBy.accessibilityId("test-Username");
    private By passwordInput = AppiumBy.accessibilityId("test-Password");
    private By loginButton = AppiumBy.accessibilityId("test-LOGIN");

    public HomePage performLogin(String username, String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(userNameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);

    }

    public static By getErrorMessage(){
        By errorMessage = AppiumBy.accessibilityId("test-Error message");
        return errorMessage;
    }

    public WebElement validLoginElement(){
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));
    }

}
