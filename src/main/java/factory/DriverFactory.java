package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver driver;
    public static String highlight;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     */
    public WebDriver init_driver(String browser, String scenarioName) {
        System.out.println("Browser used is: " + browser);
        String remoteProperty = ConfigReader.getProperty("remote");
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                if (remoteProperty.equalsIgnoreCase("no")) {
                    tlDriver.set(new ChromeDriver());
                } else if (remoteProperty.equalsIgnoreCase("yes")) {
                    init_remote_driver(browser, scenarioName);
                }
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                if (remoteProperty.equalsIgnoreCase("no")) {
                    tlDriver.set(new FirefoxDriver());
                } else if (remoteProperty.equalsIgnoreCase("yes")) {
                    init_remote_driver(browser, scenarioName);
                }
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                if (remoteProperty.equalsIgnoreCase("no")) {
                    tlDriver.set(new OperaDriver());
                } else if (remoteProperty.equalsIgnoreCase("yes")) {
                    init_remote_driver(browser, scenarioName);
                }
                break;
            default:
                System.out.println("Please pass the correct browser value");
                break;
        }
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public void init_remote_driver(String browser, String scenarioName) {
        Random random = new Random();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser) {
            case "chrome":
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                capabilities.setCapability("name", scenarioName);
                capabilities.setCapability("enableVNC", true);
                //capabilities.setCapability("enableVideo", true);
                //capabilities.setCapability("enableLogs", true);
                //capabilities.setCapability("videoName", scenarioName + random.nextInt((999 - 100) + 1) + 100);
                break;
            case "firefox":
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                break;
            case "opera":
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "opera");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                break;
            default:
                System.out.println("Please pass the correct browser value");
                break;
        }
        try {
            tlDriver.set(new RemoteWebDriver(new URL(ConfigReader.getProperty("hubURL")), capabilities));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is used to get the driver with Threadlocal
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
