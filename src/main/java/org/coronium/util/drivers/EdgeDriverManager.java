package org.coronium.util.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.coronium.util.DriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class EdgeDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        this.driver = new EdgeDriver(options);
    }
}
