package org.coronium.page.core.ui.driver.drivers;

import org.coronium.page.core.ui.driver.Driver;
import org.coronium.page.core.ui.driver.DriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        if (Driver.isMobile()) {
            //code here
        } else {
            SafariOptions safariOptions = new SafariOptions();
            safariOptions.setCapability("safari.cleanSession", true);

        }
    }
        public WebDriver getDriver(Capabilities capabilities) {
            if (Driver.isMobile()) {
                throw new IllegalArgumentException(
                        "seleniumGridURL or sauceUser and sauceKey must be specified when running on iOS");
            } else {
                return new SafariDriver(new SafariOptions(capabilities));
            }
        }

}
