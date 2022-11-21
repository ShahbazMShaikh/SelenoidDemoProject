package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.ElementUtil;
import util.PageUtils;

public class CheckoutInformationPage {

    private final WebDriver driver;
    private final ElementUtil eleUtil;
    private final PageUtils pageUtils;

    private final By firstName = By.xpath("//input[@id='first-name']");
    private final By LastName = By.xpath("//input[@id='last-name']");
    private final By zipCode = By.xpath("//input[@id='postal-code']");
    private final By continueBtn = By.xpath("//input[@id='continue']");
    private final By cancelBtn = By.xpath("//button[@id='cancel']");
    private final By title = By.xpath("//span[contains(text(),'Checkout: Your Information')]");

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
        pageUtils = new PageUtils(this.driver);
    }

    public void AddAddressInfoAndContinue() {
        eleUtil.doSendKeys(firstName, "Test");
        eleUtil.doSendKeys(LastName, "Man");
        eleUtil.doSendKeys(zipCode, "110011");
        eleUtil.doClick(continueBtn);
    }

    public void verifyCheckoutPage() {
        pageUtils.waitForPageLoad();
        Assert.assertTrue(eleUtil.doIsDisplayed(title));
    }

    public void goBackToYourCartPage() {
        eleUtil.doClick(cancelBtn);
    }
}
