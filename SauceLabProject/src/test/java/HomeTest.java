import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Setup;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class HomeTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver= new Setup(driver).setupDeviceInNativeAppium();

    }

    @Test
    public void addToCartTest(){
        new LoginPage(driver).performLogin("standard_user","secret_sauce").clickAddToCartButton();
        WebElement removeButton= new HomePage(driver).findRemoveButton();
        Assert.assertTrue(removeButton.isDisplayed());
        Assert.assertEquals(new HomePage(driver).prodName(), new CartPage(driver).itemName());
        Assert.assertEquals(new HomePage(driver).prodPrice(), new CartPage(driver).itemPrice());
    }

    @Test
    public void clickCartIcon() throws InterruptedException {
        new LoginPage(driver).performLogin("standard_user","secret_sauce")
                .clickAddToCartButton().cartIcon();
        WebElement yourCart = new HomePage(driver).yourCartTag();
        Assert.assertTrue(yourCart.isDisplayed());
    }

    @AfterMethod
    public void EndSetup(){
        new Setup(driver).EndSetup();
    }

}
