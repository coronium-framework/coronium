package org.coronium.page.core.ui.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface Driver {

    static boolean isMobile() {
        return false;
    }
    Capabilities getCapabilities();

    WebDriver getWebDriver(Capabilities capabilities);

    EventFiringWebDriver getWebDriver();
}
