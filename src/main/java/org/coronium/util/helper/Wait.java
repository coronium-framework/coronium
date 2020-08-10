package org.coronium.util.helper;

import org.coronium.test.AutoTest;
import org.openqa.selenium.WebDriver;

import static org.coronium.util.constant.Time.GLOBAL_TABLE_LOAD_TIMEOUT;

public class Wait {
    private static WebDriver driver;
    public static void waitForInvisibilityOfSpinner() {
        AutoTest.newWaitWithTimeout(GLOBAL_TABLE_LOAD_TIMEOUT.seconds())
                .until(ExtraExpectedConditions.invisibilityOfSpinner());
    }
}
