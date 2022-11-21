package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.Constants;
import util.ElementUtil;
import util.PageUtils;

public class ProductsPage {

    private final WebDriver driver;
    private final ElementUtil eleUtil;

    private final PageUtils pageUtils;

    private final By shoppingCart = By.xpath("//div[@id='shopping_cart_container']");

    private final By title = By.xpath("//span[contains(text(),'Products')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
        pageUtils = new PageUtils(this.driver);
    }

    public void doAddProducts(String productName) {
        By product = By.xpath("(//div[@class='inventory_item_name'][contains(text(),'" + productName + "')]/following::button[contains(text(),'Add to cart')])[1]");
        eleUtil.doPresenceOfElementLocated(product, Constants.DEFAULT_TIME_OUT);
        eleUtil.doClick(product);
    }

    public void verifyInventoryPage() {
        pageUtils.waitForPageLoad();
        Assert.assertTrue(eleUtil.doIsDisplayed(title));
    }

    public void doNavigateToCartPage() {
        eleUtil.doClick(shoppingCart);
        pageUtils.waitForPageLoad();
    }
}
