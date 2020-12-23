package org.coronium.page.core.ui.driver.drivers;

import org.coronium.page.core.ui.common.Property;
import org.coronium.page.core.ui.driver.DriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(Property.HEADLESS.getBoolean());
        this.driver = new FirefoxDriver(options);
    }

    @Override
    public WebDriver getDriver(Capabilities capabilities) {
        final FirefoxOptions options;
        if(capabilities instanceof FirefoxOptions){
            options = (FirefoxOptions) capabilities;
        }else{
            options = new FirefoxOptions().merge(capabilities);
        }
        return new FirefoxDriver(options);
    }
}
