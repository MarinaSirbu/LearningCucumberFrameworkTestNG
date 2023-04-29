package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinition {
    /**
     * Single responsibility principle
     * Loosely coupled
     * Factory design pattern
     */

    public String offerPageProductName;

    TestContextSetup testContextSetup;

    public OffersPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
    }

    @Then("^User searches for (.+) shortname in Offers page$")
    public void user_searches_for_same_shortname_in_offers_page(String shortname) {
        switchToOffersPage();

        OffersPage offersPage = new OffersPage(testContextSetup.testBase.driver);
        offersPage.searchItem(shortname);
        /*testContextSetup.driver
                .findElement(By.id("search-field"))
                .sendKeys(shortname, Keys.RETURN);*/

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        offerPageProductName = offersPage.getProductName();
        /*offerPageProductName = testContextSetup.driver
                .findElement(By.cssSelector("tr td:first-child"))
                .getText();*/

        System.out.println(offerPageProductName + " is found in Offers page");
    }

    public void switchToOffersPage() {
        //if switched to OffersPage -> skip below part
        if(!testContextSetup.testBase.driver.getCurrentUrl()
                .equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {

            //pageObjectManager = new PageObjectManager(testContextSetup.driver);
            LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
            //LandingPage landingPage = new LandingPage(testContextSetup.driver);*/
            landingPage.selectTopDeals();
           /* testContextSetup.driver.findElement(By.linkText("Top Deals")).click();*/

            testContextSetup.genericUtils.switchWindowToChild();
            /*Set<String> windowHandles = testContextSetup.driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();
            String parentWindow = iterator.next();
            String childWindow = iterator.next();
            testContextSetup.driver.switchTo().window(childWindow);*/
        }
    }

    @Then("validates product name in Offers page matches with Landing page")
    public void validates_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
