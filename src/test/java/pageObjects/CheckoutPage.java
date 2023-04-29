package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    private By cartBag = By.xpath("//img[@alt='Cart']");
    private By checkOutBtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By promoBtn = By.cssSelector(".promoBtn");
    private By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
    private By orderedProductName = By.className("product-name");

    public void checkOutItems(){
        driver.findElement(cartBag).click();
        driver.findElement(checkOutBtn).click();
    }

    public Boolean verifyPromoBtn(){
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean verifyPlaceOrderBtn(){
        return driver.findElement(placeOrderBtn).isDisplayed();
    }

    public String getOrderedProductName(){
        return driver.findElement(orderedProductName).getText();
    }
}
