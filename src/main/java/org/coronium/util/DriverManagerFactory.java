package org.coronium.util;

public class DriverManagerFactory {
    public static DriverManager getDriverManager (DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case IE:
                driverManager = new IEDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case CHROME:
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
