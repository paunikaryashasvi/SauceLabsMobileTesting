import Pages.LoginPage;
import Pages.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

//import static Actions.MobileActions.driver;
//


public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
    driver= new Setup(driver).setupDeviceInNativeAppium();

    }

    @Test
    public void validLogin(){
        new LoginPage(driver).performLogin("standard_user","secret_sauce");
        WebElement productTag = new LoginPage(driver).validLoginElement();
        Assert.assertTrue(productTag.isDisplayed());

    }

    @Test
    public void invalidLogin(){
        new LoginPage(driver).performLogin("locked_out_user","secret_sauce");
       Assert.assertTrue(driver.findElement(LoginPage.getErrorMessage()).isDisplayed());
    }

    @AfterMethod
    public void EndSetup(){
        new Setup(driver).EndSetup();
    }
}
