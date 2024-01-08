package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By productName = By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]");
    By productPrice = By.xpath("//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$29.99\"]");
    By addToCartButton = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");

    public HomePage clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
        return new HomePage(driver);
    }

    public WebElement findRemoveButton(){
        return driver.findElement(AppiumBy.accessibilityId("test-REMOVE"));
    }


    public CartPage cartIcon() throws InterruptedException {
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).click();
        Thread.sleep(3000);
        return new CartPage(driver);
    }

    public WebElement yourCartTag(){
        return driver.findElement(By.xpath("//android.widget.TextView[@text=\"YOUR CART\"]"));
    }

    public String prodName(){
        return driver.findElement(productName).getText();
    }

    public String prodPrice(){
        return driver.findElement(productPrice).getText();
    }



//    public String validateProductName(){
//        return driver.findElement(productName).getText();
//    }


}
