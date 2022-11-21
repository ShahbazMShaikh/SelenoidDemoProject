package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {
    private final WebDriver driver;
    private final JavaScriptUtil jsUtil;

    public PageUtils(WebDriver driver) {
        this.driver = driver;
        jsUtil = new JavaScriptUtil(this.driver);
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(driver -> jsUtil.waitForPageLoadUsingJavascript());
    }
}
