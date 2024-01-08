import Pages.CheckoutInfoPage;
import Pages.LoginPage;
import Pages.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CheckoutInfoTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver= new Setup(driver).setupDeviceInNativeAppium();

    }

    @Test
    public void checkoutInfoTest() throws InterruptedException {
        new LoginPage(driver).performLogin("standard_user","secret_sauce")
                .clickAddToCartButton().cartIcon().clickCheckoutBtn()
                .checkoutInformation("Yashi","Paunikar","440034");
        Assert.assertTrue(new CheckoutInfoPage(driver).checkoutOverviewTag().isDisplayed());
    }

    @AfterMethod
    public void EndSetup(){
        new Setup(driver).EndSetup();
    }
}

