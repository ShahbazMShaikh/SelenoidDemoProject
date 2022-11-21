package stepDefinitions;

import factory.DriverFactory;
import pages.CheckoutInformationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutPageStepDef {
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(DriverFactory.getDriver());

    @Then("Verify user is redirected to Checkout page")
    public void verifyUserIsRedirectedToCheckoutPage() {
        checkoutInformationPage.verifyCheckoutPage();
    }

    @When("User goes back to YOUR CART Page")
    public void userGoesBackToYOURCARTPage() {
        checkoutInformationPage.goBackToYourCartPage();
    }
}
