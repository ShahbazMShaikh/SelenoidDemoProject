package Hooks;

import util.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {

    private WebDriver driver;
    Properties properties;

    @Before(order = 0)
    public void getProperties() {
        ConfigReader configReader = new ConfigReader();
        properties = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser(Scenario scenario) {
        String browserName = properties.getProperty("browser");
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName, scenario.getName());
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
