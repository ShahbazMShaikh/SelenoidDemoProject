package stepDefinitions;

import factory.DriverFactory;
import pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwagLabsInventoryPageStepDef {
    ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

    @Then("Verify user is navigated to SWAGLABS Home page")
    public void verify_user_is_navigated_to_swaglabs_home_page() {
        productsPage.verifyInventoryPage();
    }

    @When("User adds product {string} to the cart")
    public void user_adds_product_to_the_cart(String productName) {
        productsPage.doAddProducts(productName);
    }

    @And("User goes to YOUR CART Page")
    public void userGoesToYOURCARTPage() {
        productsPage.doNavigateToCartPage();
    }
}
