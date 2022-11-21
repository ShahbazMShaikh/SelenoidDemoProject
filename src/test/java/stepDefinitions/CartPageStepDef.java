package stepDefinitions;

import factory.DriverFactory;
import pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageStepDef {
    CartPage cartPage = new CartPage(DriverFactory.getDriver());

    @Then("Verify product {string} is added to the cart")
    public void verify_product_is_added_to_the_cart(String productName) {
        cartPage.verifyProductsAdded(productName);
    }

    @When("User clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        cartPage.doCheckOut();
    }

    @And("User removes the product {string} from cart")
    public void userRemovesTheProductProductNameFromCart(String productName) {
        cartPage.removeProductFromCart(productName);
    }
}
