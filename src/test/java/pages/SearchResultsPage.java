package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Constants;
import util.ElementUtil;

import java.util.List;

public class SearchResultsPage {

    private final WebDriver driver;
    private final ElementUtil eleUtil;

    private final By searchHeaderName = By.cssSelector("div#content h1");
    private final By productResults = By.cssSelector("div.caption a");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
    }

    public String getSearchHeaderName() {
        return eleUtil.doGetText(searchHeaderName);
    }

    public int getProductListCount() {
        return eleUtil.waitForVisibilityOfElements(productResults, Constants.DEFAULT_TIME_OUT).size();
    }

    public void selectProduct(String mainProductName) {
        List<WebElement> searchList =
                eleUtil.waitForVisibilityOfElements(productResults, Constants.DEFAULT_TIME_OUT);
        for (WebElement e : searchList) {
            String text = e.getText();
            if (text.equalsIgnoreCase(mainProductName)) {
                e.click();
                break;
            }
        }
    }


}
