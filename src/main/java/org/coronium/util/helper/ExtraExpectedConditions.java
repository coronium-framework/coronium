package org.coronium.util.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.function.Function;

import static org.coronium.util.constant.Locator.*;

public class ExtraExpectedConditions {
    public static ExpectedCondition<Boolean> invisibilityOfSpinner() {
        return expectedCondition(
                driver -> {
                    List<WebElement> elements = driver.findElements(By.cssSelector(SPINNER_CSS));
                    return elements.size() <= 0 ||
                            elements.parallelStream().noneMatch(WebElement::isDisplayed);
                },
                "Spinner to not be present or visible"
        );
    }

    public static ExpectedCondition<Boolean> visibilityOfSpinner() {
        return expectedCondition(
                driver -> {
                    List<WebElement> elements = driver.findElements(By.cssSelector(SPINNER_CSS));
                    return elements.size() > 0 &&
                            elements.parallelStream().anyMatch(WebElement::isDisplayed);
                },
                "Spinner to  be present or visible"
        );
    }

    public static ExpectedCondition<Boolean> invisibilityOfModal() {
        return expectedCondition(
                driver -> {
                    List<WebElement> elements = driver.findElements(By.cssSelector(MODAL_CSS));
                    return elements.size() <= 0 ||
                            elements.parallelStream().noneMatch(WebElement::isDisplayed);
                },
                "Modal to not be present or visible"
        );
    }

    public static ExpectedCondition<Boolean> visibilityOfModal() {
        return expectedCondition(
                driver -> {
                    List<WebElement> elements = driver.findElements(By.cssSelector(MODAL_CSS));
                    return elements.size() > 0 &&
                            elements.parallelStream().anyMatch(WebElement::isDisplayed);
                },
                "Modal to not be present or visible"
        );
    }

    private static <T> ExpectedCondition<T> expectedCondition(Function<WebDriver, T> function, String string) {
        return new ExpectedCondition<T>() {
            @Override
            public T apply(WebDriver webDriver) {
                return function.apply(webDriver);
            }

            @Override
            public String toString() {
                return string;
            }
        };
    }

    public static ExpectedCondition<Boolean> visibilityOfStyleDisplayBlock() {
        return expectedCondition(
                driver -> {
                    List<WebElement> elements = driver.findElements(By.cssSelector(STYLE_DISPLAY_BLOCK_CSS));
                    return elements.size() > 0 ||
                            elements.parallelStream().anyMatch(WebElement::isDisplayed);
                },
                "Style display block to not be present or visible"
        );
    }

    public static ExpectedCondition<Boolean> invisibilityOfStyleDisplayBlock() {
        return expectedCondition(
                driver -> {
                    List<WebElement> elements = driver.findElements(By.cssSelector(STYLE_DISPLAY_BLOCK_CSS));
                    return elements.size() <= 0 ||
                            elements.parallelStream().noneMatch(WebElement::isDisplayed);
                },
                "Style display block to not be present or visible"
        );
    }

    public static ExpectedCondition<Boolean> invisibilityOfWaitingBar() {
        return expectedCondition(
                driver -> {
                    List<WebElement> elements = driver.findElements(By.cssSelector(WAITING_BAR_CSS));
                    return elements.size() <= 0 ||
                            elements.parallelStream().noneMatch(WebElement::isDisplayed);
                },
                "Spinner to not be present or visible"
        );
    }
}
