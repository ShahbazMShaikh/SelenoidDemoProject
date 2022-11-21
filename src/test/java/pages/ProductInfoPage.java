package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Constants;
import util.ElementUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductInfoPage {

    private final WebDriver driver;
    private final ElementUtil eleUtil;

    private Map<String, String> productInfoMap;

    private final By productHeader = By.cssSelector("div#content h1");
    private final By productImages = By.cssSelector("ul.thumbnails img");
    private final By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
    private final By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
    private final By quantity = By.id("input-quantity");
    private final By addToCartBtn = By.id("button-cart");
    private final By successMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");

    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(this.driver);
    }

    public String getProductHeaderText() {
        return eleUtil.doGetText(productHeader).trim();
    }

    public int getProductImagesCount() {
        return eleUtil.waitForVisibilityOfElements(productImages, Constants.DEFAULT_TIME_OUT).size();
    }

    public Map<String, String> getProductInfo() {
        productInfoMap = new LinkedHashMap<>();
        productInfoMap.put("name", getProductHeaderText());
        getProductMetaData();
        getProductPriceData();
        return productInfoMap;
    }

    private void getProductMetaData() {
        List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
        System.out.println("total product meta data: " + metaDataList.size());
        // meta data:
        for (WebElement e : metaDataList) {
            // Brand: Apple
            String[] meta = e.getText().split(":");
            String metaKey = meta[0].trim();
            String metaValue = meta[1].trim();
            productInfoMap.put(metaKey, metaValue);
        }
    }

    private void getProductPriceData() {
        List<WebElement> priceList = eleUtil.getElements(productPriceData);
        System.out.println("Total price List" + priceList.size());
        String mainPrice = priceList.get(0).getText();
        String exTax = priceList.get(1).getText();
        productInfoMap.put("Price", mainPrice);
        productInfoMap.put("Ex Tax", exTax);
    }

}
