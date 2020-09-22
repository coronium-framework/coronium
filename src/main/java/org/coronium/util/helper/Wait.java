package org.coronium.util.helper;

import org.coronium.test.AutoTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.coronium.util.constant.Time.GLOBAL_TABLE_LOAD_TIMEOUT;
import static org.coronium.util.constant.Time.GLOBAL_WAIT_LOADING_TIMEOUT;

public class Wait {
    private static WebDriver driver;
    public static void waitForInvisibilityOfSpinner() {
        AutoTest.newWaitWithTimeout(GLOBAL_TABLE_LOAD_TIMEOUT.seconds())
                .until(ExtraExpectedConditions.invisibilityOfSpinner());
    }

    public static void waitForVisibilityOf(WebElement webElement) {
        try {
            AutoTest.newWaitWithTimeout(GLOBAL_WAIT_LOADING_TIMEOUT.seconds())
                    .until(ExpectedConditions.visibilityOf(webElement));
        } catch (org.openqa.selenium.TimeoutException exception) {
            //ignore
        }
    }

    public static void waitInSeconds() {
        try {
            int seconds = 10;
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            //ignore
        }
    }

    public static void waitExplicitly(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            //ignore
        }
    }
}
