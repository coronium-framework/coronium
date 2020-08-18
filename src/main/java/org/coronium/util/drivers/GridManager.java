package org.coronium.util.drivers;


import org.coronium.page.core.ui.common.Property;
import org.coronium.util.AbstractDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.coronium.page.core.ui.common.Property.*;

public class GridManager extends AbstractDriver {
    private URL remoteURL;
    private Capabilities capabilities;

    public GridManager(Capabilities capabilities) {
        this.capabilities = capabilities;
        try {
            this.remoteURL = new URL(Property.GRID_URL.getValue());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Capabilities getCapabilities() {
        MutableCapabilities mutableCapabilities = new MutableCapabilities(capabilities);
        if (BROWSER_VERSION.isSpecified()) {
            mutableCapabilities.setCapability("version", BROWSER_VERSION.getValue());
        }
        if (PLATFORM.isSpecified()) {
            mutableCapabilities.setCapability("platform", PLATFORM_VERSION.getValue());
        }
        if (APPLICATION_NAME.isSpecified()) {
            mutableCapabilities.setCapability("applicationName", APPLICATION_NAME.getValue());
        }
        return mutableCapabilities;
    }

    @Override
    public WebDriver getWebDriver(Capabilities capabilities) {
        return null;
    }
}
