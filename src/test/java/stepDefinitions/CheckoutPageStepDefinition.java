package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
    /**
     * Single responsibility principle
     * Loosely coupled
     * Factory design pattern
     */

    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;


    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup=testContextSetup;
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("User proceeds to Checkout")
    public void userProceedsToCheckout() {
        checkoutPage.checkOutItems();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^validate the (.+) items in Checkout page$")
    public void validateTheNameItemsInCheckoutPage(String name) {
        Assert.assertEquals(checkoutPage.getOrderedProductName(),testContextSetup.landingPageProductDescription);
    }

    @Then("verify User has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        Assert.assertTrue(checkoutPage.verifyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());
    }

}
