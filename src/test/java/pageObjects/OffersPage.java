package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    public WebDriver driver;

    public OffersPage(WebDriver driver){
        this.driver=driver;
    }

    private By search = By.id("search-field");

    private By productName = By.cssSelector("tr td:first-child");

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
}
