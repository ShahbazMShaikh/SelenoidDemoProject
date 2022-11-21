package pages;

import org.openqa.selenium.WebDriver;
import util.ElementUtil;

public class OrderReviewPage {

    private final WebDriver driver;
    private final ElementUtil eleUtil;

    public OrderReviewPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
    }

}
