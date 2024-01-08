import Pages.CartPage;
import Pages.LoginPage;
import Pages.Setup;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class CartTest  {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver= new Setup(driver).setupDeviceInNativeAppium();

    }
    @Test
    public void clearCartTest() throws InterruptedException {
        new LoginPage(driver).performLogin("standard_user","secret_sauce")
                .clickAddToCartButton().cartIcon().removeBtnClick();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(new CartPage(driver).itemsPresent(),"notPresent");



    }

    @Test
    public void checkoutTest() throws InterruptedException {
        new LoginPage(driver).performLogin("standard_user","secret_sauce")
                .clickAddToCartButton().cartIcon().clickCheckoutBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(new CartPage(driver).checkoutInformationTag().isDisplayed());
    }

    @AfterMethod
    public void EndSetup(){
        new Setup(driver).EndSetup();
    }
}
