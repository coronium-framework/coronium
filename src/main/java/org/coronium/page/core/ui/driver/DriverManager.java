package org.coronium.page.core.ui.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createWebDriver();
    public void quitWebDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver() {
        try{
            if (driver == null) {
                createWebDriver();
            }}catch(Exception e){
            e.printStackTrace();
        }
        return driver;
    }
}
