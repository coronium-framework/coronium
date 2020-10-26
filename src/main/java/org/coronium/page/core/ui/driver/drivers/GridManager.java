package org.coronium.page.core.ui.driver.drivers;


import org.coronium.page.core.ui.common.Property;
import org.coronium.page.core.ui.driver.AbstractDriver;
import org.coronium.page.core.ui.driver.WebDriverWrapper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.coronium.page.core.ui.common.Property.*;

public class GridManager extends AbstractDriver {
    private URL remoteURL;
    private DesiredCapabilities desiredCapabilities;

    public GridManager(DesiredCapabilities desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;
        try {
            this.remoteURL = new URL(Property.GRID_URL.getValue());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void tearDown() {

    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        if (BROWSER_VERSION.isSpecified()) {
            desiredCapabilities.setCapability("version", BROWSER_VERSION.getValue());
        }
        if (PLATFORM.isSpecified()) {
            desiredCapabilities.setCapability("platform", PLATFORM_VERSION.getValue());
        }
        if (APPLICATION_NAME.isSpecified()) {
            desiredCapabilities.setCapability("applicationName", APPLICATION_NAME.getValue());
        }
        return desiredCapabilities;
    }

    @Override
    public Capabilities getCapabilities() {
        return null;
    }

    @Override
    public WebDriver getWebDriver(Capabilities capabilities) {
        return new RemoteWebDriver(remoteURL, capabilities);
    }

    @Override
    public WebDriverWrapper getWebDriver() {
        return null;
    }
}
