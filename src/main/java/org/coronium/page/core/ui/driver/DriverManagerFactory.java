package org.coronium.page.core.ui.driver;

import org.coronium.page.core.ui.common.Property;
import org.coronium.page.core.ui.driver.drivers.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManagerFactory {

    /** Supported remote grids. */
    private enum RemoteGrid {
        SAUCE, BROWSERSTACK, GRID
    }

    //Platforms for remote grids
    public enum Platform {
        WINDOWS, OSX, IOS, ANDROID, NONE
    }
    public static Driver instantiateDesiredRemote(Driver driver) {

        DesiredCapabilities desiredCapabilities = driver.getDesiredCapabilities();
        Platform platform = getPlatformType();
        switch (getRemoteType()) {
            case GRID:
                return new GridManager(desiredCapabilities);
            default:
                return driver;
        }
    }

    public static DriverManager getDriverManager (DriverType type) {

        switch (type) {
            case IE:
                return new IEDriverManager();
            case EDGE:
                return new EdgeDriverManager();
            case FIREFOX:
                return new FirefoxDriverManager();
            case SAFARI:
                return new SafariDriverManager();
            case CHROME:
                return new ChromeDriverManager();
            default:
                throw new IllegalArgumentException("Invalid Browser specified");
        }
    }

    //for diff OS
    private static Platform getPlatformType() {
        if (Property.PLATFORM.isSpecified()) {
            return Platform.valueOf(Property.PLATFORM.getValue().toUpperCase());
        } else {
            return Platform.NONE;
        }
    }

    private static RemoteGrid getRemoteType() {
            return RemoteGrid.GRID;
    }
}
