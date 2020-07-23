package org.coronium.util;

public class DriverManagerFactory {
    public static DriverManager getDriverManager (DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case FIREFOX:
            case IE:
            case EDGE:
            case CHROME:
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
