package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;
import util.Constants;
import util.ElementUtil;

public class SwagLabsLoginPage {
    private final WebDriver driver;
    private final ElementUtil eleUtil;

    //By Locators
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    public SwagLabsLoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
    }

    //Page Actions
    public String getLoginPageTitle() {
        return eleUtil.getPageTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
    }

    public void doLogin(String uname, String pwd) {
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
        uname = ConfigReader.getProperty(uname);
        pwd = ConfigReader.getProperty(pwd);
        eleUtil.doPresenceOfElementLocated(userName, Constants.DEFAULT_TIME_OUT).sendKeys(uname);
        eleUtil.doSendKeys(password, pwd);
        eleUtil.doClick(loginButton);
    }

}
