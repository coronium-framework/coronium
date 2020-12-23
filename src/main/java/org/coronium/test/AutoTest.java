package org.coronium.test;

import org.coronium.page.core.ui.driver.DriverManager;
import org.coronium.page.core.ui.driver.DriverType;
import org.coronium.page.core.ui.driver.lifecycle.DriverLifecycle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.time.Duration;


public  class AutoTest {
    protected static String environment = System.getProperty("environment");
    protected static String autoGridURL = System.getProperty("autoGridURL");
    protected static WebDriver driver = null;
    private static DriverLifecycle driverLifecycle;
    private static final ThreadLocal<Wait<WebDriver>> wait = new ThreadLocal<>();
    private static final ThreadLocal<AutoTest> autoTest = ThreadLocal.withInitial(AutoTest::new);
    //private static final ThreadLocal<Wait<WebDriver>> wait = ThreadLocal.withInitial(() -> null);
    protected static String browser = System.getProperty("browser");

    public static AutoTest get(){
        return autoTest.get();
    }

    @BeforeClass( alwaysRun = true )
    public void beforeClass() throws MalformedURLException {
        initDriver();
    }

    @AfterClass( alwaysRun = true )
    public void afterClass() {
        driver.quit();
        driver = null;
    }

    @BeforeMethod( alwaysRun = true )
    public static void initDriver() throws MalformedURLException {
        if (driver == null) {
            if (autoGridURL != null) {
                /* To Do:
                 * Add code for other browsers when using grid
                 */
                driver = new RemoteWebDriver(new URL(autoGridURL), new ChromeOptions());
            } else {
                /*DriverManagerFactory driverManagerFactory = new DriverManagerFactory();*/
                DriverManager driverManager = null;
                try {
                    switch (browser) {
                        case "ie":
                            driverManager = driverManager.getDriverManager(DriverType.IE);
                            break;
                        case "edge":
                            driverManager = driverManager.getDriverManager(DriverType.EDGE);
                            break;
                        case "gecko":
                        case "firefox":
                            driverManager = driverManager.getDriverManager(DriverType.FIREFOX);
                            break;
                        case "safari":
                            driverManager = driverManager.getDriverManager(DriverType.SAFARI);
                            break;
                        default:
                            driverManager = driverManager.getDriverManager(DriverType.CHROME);
                            break;
                    }
                } catch (Exception e) {
                    driverManager = driverManager.getDriverManager(DriverType.CHROME);
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

    public static WebDriver getDriver() { return driver; }

    public static Wait<WebDriver> getWait() { return wait.get();  }
}
