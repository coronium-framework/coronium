package org.coronium.page.core.ui.driver;

import org.coronium.page.core.ui.common.Property;
import org.coronium.page.core.ui.driver.drivers.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class DriverManager {
    protected WebDriver driver;

    /** Supported remote grids. */
    private enum RemoteGrid {
        SAUCE, BROWSERSTACK, GRID
    }

    //Platforms for remote grids
    public enum Platform {
        WINDOWS, OSX, IOS, ANDROID, NONE
    }


    protected abstract void createWebDriver();
    public void quitWebDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver() { // WebDriver getWebDriver
        try{
            if (driver == null) {
                createWebDriver();
            }}catch(Exception e){
            e.printStackTrace();
        }
        return driver;
    }

    public abstract WebDriver getDriver(Capabilities capabilities);


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
