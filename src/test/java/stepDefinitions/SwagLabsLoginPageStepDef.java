package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import pages.SwagLabsLoginPage;

public class SwagLabsLoginPageStepDef {
    SwagLabsLoginPage loginPage = new SwagLabsLoginPage(DriverFactory.getDriver());

    @Given("User logs in to SWAGLABS with {string} and {string}")
    public void user_logs_in_to_swaglabs_with_and(String username, String password) {
        loginPage.doLogin(username, password);
    }
}
