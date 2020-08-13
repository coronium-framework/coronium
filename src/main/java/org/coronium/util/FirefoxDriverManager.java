package org.coronium.util;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
        this.driver = new FirefoxDriver();
    }
}

