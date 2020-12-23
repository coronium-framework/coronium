package org.coronium.page.core.ui.driver.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.coronium.page.core.ui.driver.DriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        WebDriverManager.iedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        InternetExplorerOptions options = new InternetExplorerOptions(capabilities);
        this.driver = new InternetExplorerDriver(options);
    }

    @Override
    public WebDriver getDriver(Capabilities capabilities) {
        return new InternetExplorerDriver(new InternetExplorerOptions(capabilities));
    }
}
