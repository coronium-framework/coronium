package org.coronium.util.drivers;

import org.coronium.util.DriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        this.driver = new FirefoxDriver(options);
    }
}
