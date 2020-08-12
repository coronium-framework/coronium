package org.coronium.util;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        InternetExplorerOptions options = new InternetExplorerOptions(capabilities);
        System.setProperty("webdriver.ie.driver","C:\\SeleniumDrivers\\IEDriverServer.exe");
        this.driver = new InternetExplorerDriver(options);
    }
}
