import Pages.CheckoutOverviewPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CheckoutOverviewTest  {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver= new Setup(driver).setupDeviceInNativeAppium();

    }

    @Test
    public void clickFinishBtnTest() throws InterruptedException {
        new LoginPage(driver).performLogin("standard_user","secret_sauce")
                .clickAddToCartButton();

       String homeProductName = new HomePage(driver).prodName();
       String homeProductPrice = new HomePage(driver).prodPrice();

        new HomePage(driver).cartIcon().clickCheckoutBtn()
                .checkoutInformation("Yashi","Paunikar","440034");

        String overviewItemName= new CheckoutOverviewPage(driver).newItemName();
        String overviewItemPrice= new CheckoutOverviewPage(driver).newItemPrice();

        Assert.assertEquals(homeProductName,overviewItemName);
        Assert.assertEquals(homeProductPrice,overviewItemPrice);

        new CheckoutOverviewPage(driver).clickFinishBtn();
        Assert.assertTrue(new CheckoutOverviewPage(driver).checkoutCompleteTag().isDisplayed());
    }

    @AfterMethod
    public void EndSetup(){
        new Setup(driver).EndSetup();
    }
}
