package org.coronium.util.drivers;

import org.coronium.util.DriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
        this.driver = new FirefoxDriver();
    }
}
