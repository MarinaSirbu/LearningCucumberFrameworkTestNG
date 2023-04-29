package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver=driver;
    }

    private By search = By.className("search-keyword");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.linkText("Top Deals");
    private By incrementBtn = By.className("increment");
    private By addToCartBtn = By.cssSelector(".product-action button");

    public void searchItem(String name){
        driver
                .findElement(search)
                .sendKeys(name, Keys.RETURN);
    }

    public String getProductName(){
        return driver
                .findElement(productName)
                .getText();
    }

    public void selectTopDeals(){
        driver
                .findElement(topDeals)
                .click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }

    public void incrementQuantity(int quantity){
        int i = quantity-1;
        while (i>0)
        {
            driver.findElement(incrementBtn).click();
            i--;
        }
    }

    public void addToCart(){
        driver.findElement(addToCartBtn).click();
    }
}
