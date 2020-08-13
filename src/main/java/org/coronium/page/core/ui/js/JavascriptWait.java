package org.coronium.page.core.ui.js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class JavascriptWait {

    private final Wait<WebDriver> wait;
    private final JavascriptExecutor javascriptExecutor;

    public JavascriptWait(WebDriver driver, Wait<WebDriver> wait) {
        this.wait = wait;
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }


    public void waitForJavascriptEventsOnLoad(){

    }
}
