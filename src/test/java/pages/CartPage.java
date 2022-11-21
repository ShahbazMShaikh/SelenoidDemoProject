package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.ElementUtil;

public class CartPage {
    private final WebDriver driver;
    private final ElementUtil eleUtil;

    //private By continueShoppingBtn= By.xpath("//button[@id='continue-shopping']");
    private final By checkOutBtn = By.xpath("//button[@id='checkout']");


    public CartPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
    }


    public void doCheckOut() {
        eleUtil.doClick(checkOutBtn);
    }

    public void verifyProductsAdded(String productName) {
        By productAdded = By.xpath("//div[@class='cart_item']/div[@class='cart_item_label']//div[contains(text(),'" + productName + "')]");
        Assert.assertTrue(eleUtil.doIsDisplayed(productAdded));
    }

    public void removeProductFromCart(String productName) {
        By productToBeRemoved = By.xpath("//div[contains(text(),'" + productName + "')]//following::button[contains(text(),'Remove')][1]");
        eleUtil.doClick(productToBeRemoved);
    }
}
