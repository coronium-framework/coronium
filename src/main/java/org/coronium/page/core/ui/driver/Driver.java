package org.coronium.page.core.ui.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.coronium.page.core.ui.common.Property.APP_PATH;

public interface Driver {

    static boolean isMobile() {
        return false;
    }
    /** @return whether a native app is being tested. */
    static boolean isNative() { return APP_PATH.isSpecified(); }
    /** Method to tear down the driver object. */
    void tearDown();

    /** Method to set-up the driver object. */
    void initialise();
    /**
     * Implemented in each Driver Type to specify the capabilities of that browser.
     *
     * @return Desired Capabilities of each browser
     */
    DesiredCapabilities getDesiredCapabilities();
    Capabilities getCapabilities();

    WebDriver getWebDriver(Capabilities capabilities);

    EventFiringWebDriver getWebDriver();
}
