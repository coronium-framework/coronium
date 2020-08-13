package org.coronium.util;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class EdgeDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        EdgeOptions options = new EdgeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        System.setProperty("webdriver.edge.driver","C:\\SeleniumDrivers\\msedgedriver.exe");
        this.driver = new EdgeDriver(options);
    }
}
