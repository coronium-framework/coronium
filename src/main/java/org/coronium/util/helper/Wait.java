package org.coronium.util.helper;

import org.coronium.test.AutoTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import static org.coronium.util.constant.Time.*;

public class Wait {
    private static WebDriver driver;
    public static void waitForModalBlock() {
        try {
            AutoTest.newWaitWithTimeout(GLOBAL_PAGE_LOAD_TIMEOUT.seconds()).until(ExtraExpectedConditions.invisibilityOfModal());
        } catch (org.openqa.selenium.TimeoutException exception) {
            //ignore
        }
    }

    public static void waitForDisplayUnblock() {
        try {
            AutoTest.newWaitWithTimeout(GLOBAL_TABLE_LOAD_TIMEOUT.seconds()).until(ExtraExpectedConditions.invisibilityOfStyleDisplayBlock());
        } catch (org.openqa.selenium.TimeoutException exception) {
            //ignore
        }
    }

    public static void waitForDisplayUnblockQuick() {
        try {
            AutoTest.newWaitWithTimeout(GLOBAL_TABLE_LOAD_QUICK_TIMEOUT.seconds()).until(ExtraExpectedConditions.invisibilityOfStyleDisplayBlock());
        } catch (org.openqa.selenium.TimeoutException exception) {
            //ignore
        }
    }

    public static void waitForDisplayBlockUnblock() {
        try {
            AutoTest.newWaitWithTimeout(GLOBAL_TABLE_LOAD_TIMEOUT.seconds()).until(ExtraExpectedConditions.visibilityOfStyleDisplayBlock());
            AutoTest.newWaitWithTimeout(GLOBAL_TABLE_LOAD_TIMEOUT.seconds()).until(ExtraExpectedConditions.invisibilityOfStyleDisplayBlock());
        } catch (org.openqa.selenium.TimeoutException exception) {
            //ignore
        }
    }

    public static void waitForSpinnerInside(Table table) {
        try {
            AutoTest.newWaitWithTimeout(GLOBAL_TABLE_LOAD_TIMEOUT.seconds())
                    .until(ExpectedConditions.invisibilityOf(table.findElement(By.cssSelector("div[style='display: block;']"))));
        } catch (NoSuchElementException e) {
            //ignore
        }
    }

    public static void waitForSpinnerInside(TypifiedElement typifiedElement) {
        try {
            AutoTest.newWaitWithTimeout(GLOBAL_TABLE_LOAD_TIMEOUT.seconds())
                    .until(ExpectedConditions.invisibilityOf(typifiedElement.findElement(By.cssSelector("div[style='display: block;']"))));
        } catch (NoSuchElementException e) {
            //ignore
        }
    }

    public static void waitForVisibilityOf(WebElement webElement) {
        try {
            AutoTest.newWaitWithTimeout(GLOBAL_WAIT_LOADING_TIMEOUT.seconds())
                    .until(ExpectedConditions.visibilityOf(webElement));
        } catch (org.openqa.selenium.TimeoutException exception) {
            //ignore
        }
    }

    public static void waitForInvisibilityOf(WebElement webElement) {
        AutoTest.newWaitWithTimeout(GLOBAL_PAGE_LOAD_TIMEOUT.seconds())
                .until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static void waitForInvisibilityOfSpinner() {
        AutoTest.newWaitWithTimeout(GLOBAL_TABLE_LOAD_TIMEOUT.seconds())
                .until(ExtraExpectedConditions
                        .invisibilityOfSpinner());
    }

    public static void waitForElementToBeClickable(WebElement element) {
        AutoTest.newWaitWithTimeout(GLOBAL_PAGE_LOAD_TIMEOUT.seconds())
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForTableLoad() {
        try {
            AutoTest.newWaitWithTimeout(100)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("./ancestor-or-self::table")));
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

    // LAST RESORT ONLY
    public static void waitExplicitly(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            //ignore
        }
    }
}
