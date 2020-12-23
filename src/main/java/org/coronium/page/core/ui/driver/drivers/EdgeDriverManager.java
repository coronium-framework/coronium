package org.coronium.page.core.ui.driver.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.coronium.page.core.ui.driver.DriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
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

    @Override
    public WebDriver getDriver(Capabilities capabilities) {
        final EdgeOptions edgeOptions;
        if (capabilities instanceof EdgeOptions){
            edgeOptions = (EdgeOptions) capabilities;
        }else {
            edgeOptions = new EdgeOptions().merge(capabilities);
        }
        return new EdgeDriver(edgeOptions);
    }
}

