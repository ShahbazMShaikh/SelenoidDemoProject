package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Constants;
import util.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private final WebDriver driver;
    private final ElementUtil eleUtil;

    private final By accSection = By.cssSelector("div#content h2");
    private final By header = By.cssSelector("div#logo a");
    private final By logout = By.linkText("Logout");
    private final By searchField = By.xpath("//input[@name='search']");
    private final By searchButton = By.cssSelector("div#search button");


    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
    }

    public String getAccountsPageTitle() {
        return eleUtil.getPageTitle(Constants.ACC_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
    }

    public boolean getAccountPageUrl() {
        return eleUtil.waitForURL("route=account", Constants.DEFAULT_TIME_OUT);
    }

    public String getAccPageHeader() {
        return eleUtil.doGetText(header);
    }

    public List<String> getAccSectionList() {
        List<String> accSecListText = new ArrayList<String>();
        List<WebElement> accSecList = eleUtil.waitForVisibilityOfElements(accSection, Constants.DEFAULT_TIME_OUT);

        for (WebElement e : accSecList) {
            accSecListText.add(e.getText());
        }

        return accSecListText;
    }

    public SearchResultsPage doProductSearch(String ProductName) {
        System.out.println("Searching for ::" + ProductName);
        eleUtil.doSendKeys(searchField, ProductName);
        eleUtil.doClick(searchButton);
        return new SearchResultsPage(driver);

    }

    public boolean isLogOutLinkExist() {
        return eleUtil.doIsDisplayed(logout);
    }

    public void logOut() {
        if (isLogOutLinkExist()) {
            eleUtil.doClick(logout);
        }
    }

}
