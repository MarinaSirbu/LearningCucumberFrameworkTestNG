package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    /**
     * Single responsibility principle
     * Loosely coupled
     * Factory design pattern
     */

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenKart Landing page")
    public void user_is_on_green_kart_landing_page() {

        /*WebDriverManager.chromedriver().setup();
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");*/
        String currentUrl = testContextSetup.testBase.driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://rahulshettyacademy.com/seleniumPractise/#/");
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

        System.out.println("User is on GreenKart Landing page: " + currentUrl);
    }
    @When("^User searches with shortname (.+) and extracts actual name of product$")
    public void user_searches_with_shortname_and_extracts_actual_name_of_product(String shortname) {
        //LandingPage landingPage = new LandingPage(testContextSetup.driver);

        landingPage.searchItem(shortname);
        /*testContextSetup.driver
                .findElement(By.className("search-keyword"))
                .sendKeys(name, Keys.RETURN);*/

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testContextSetup.landingPageProductDescription = landingPage.getProductName();

        testContextSetup.landingPageProductName = landingPage
                .getProductName()
                .split("-")[0]
                .trim();
        /*testContextSetup.landingPageProductName = testContextSetup.driver
                .findElement(By.cssSelector("h4.product-name"))
                .getText()
                .split("-")[0]
                .trim();*/

        System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");
    }

    @When("User added {string} items of the selected product to cart")
    public void userAddedNrItemsItemsOfTheSelectedProductToCart(String nrItems) {
        landingPage.incrementQuantity(Integer.parseInt(nrItems));
        landingPage.addToCart();
    }
}
