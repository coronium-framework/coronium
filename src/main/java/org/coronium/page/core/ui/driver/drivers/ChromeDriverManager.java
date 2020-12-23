package org.coronium.page.core.ui.driver.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.coronium.page.core.ui.driver.DriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public  class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        this.driver = new ChromeDriver(options);
    }

    @Override
    public WebDriver getDriver(Capabilities capabilities) {
        final ChromeOptions chromeOptions;
        if (capabilities instanceof ChromeOptions){
            chromeOptions = (ChromeOptions) capabilities;
        }else {
            chromeOptions = new ChromeOptions().merge(capabilities);
        }
        return new ChromeDriver(chromeOptions);
    }
}