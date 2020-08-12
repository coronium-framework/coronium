package org.coronium.test;

import org.coronium.util.DriverManager;
import org.coronium.util.DriverManagerFactory;
import org.coronium.util.DriverType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public abstract class AutoTest {
    protected static String environment = System.getProperty("environment");
    protected static WebDriver driver = null;
    private static final ThreadLocal<Wait<WebDriver>> wait = ThreadLocal.withInitial(() -> null);

    @BeforeClass
    public void beforeClass() {
        initDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        driver = null;
    }

    public static void initDriver() {
        if (driver == null) {
            DriverManagerFactory driverManagerFactory = new DriverManagerFactory();
            DriverManager driverManager = driverManagerFactory.getDriverManager(DriverType.CHROME);
            driver = driverManager.getWebDriver();
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
