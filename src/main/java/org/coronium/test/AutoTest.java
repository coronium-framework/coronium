package org.coronium.test;

import org.coronium.page.core.ui.driver.Driver;
import org.coronium.page.core.ui.driver.DriverManager;
import org.coronium.page.core.ui.driver.DriverManagerFactory;
import org.coronium.page.core.ui.driver.DriverType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.time.Duration;


public abstract class AutoTest {
    protected static String environment = System.getProperty("environment");
    protected static String autoGridURL = System.getProperty("autoGridURL");
    protected static WebDriver driver = null;
    private static final ThreadLocal<Wait<WebDriver>> wait = ThreadLocal.withInitial(() -> null);
    protected static String browser = System.getProperty("browser");

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        initDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        driver = null;
    }

    public static void initDriver() throws MalformedURLException {
        if (driver == null) {
            if (autoGridURL != null) {
                /* To Do:
                 * Add code for other browsers when using grid
                 */
                driver = new RemoteWebDriver(new URL(autoGridURL), new ChromeOptions());
            } else {
                DriverManagerFactory driverManagerFactory = new DriverManagerFactory();
                DriverManager driverManager = null;
                try {
                    switch (browser) {
                        case "ie":
                            driverManager = driverManagerFactory.getDriverManager(DriverType.IE);
                            break;
                        case "edge":
                            driverManager = driverManagerFactory.getDriverManager(DriverType.EDGE);
                            break;
                        case "gecko":
                        case "firefox":
                            driverManager = driverManagerFactory.getDriverManager(DriverType.FIREFOX);
                            break;
                        case "safari":
                            driverManager = driverManagerFactory.getDriverManager(DriverType.SAFARI);
                            break;
                        default:
                            driverManager = driverManagerFactory.getDriverManager(DriverType.CHROME);
                            break;
                    }
                } catch (Exception e) {
                    driverManager = driverManagerFactory.getDriverManager(DriverType.CHROME);
                }

                driver = driverManager.getWebDriver();
            }
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            driver.get(environment);
        }
    }

    public static Wait<WebDriver> newWaitWithTimeout(long timeout){
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofDays(timeout)) //if breaks,change here
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Wait<WebDriver> getWait() {
        return wait.get(); //need to update
    }
}
