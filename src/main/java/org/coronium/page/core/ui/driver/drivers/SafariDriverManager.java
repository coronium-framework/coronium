package org.coronium.page.core.ui.driver.drivers;

import org.coronium.page.core.ui.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        SafariOptions options = new SafariOptions();
        this.driver = (WebDriver) new SafariOptions(options);
    }
}
