package org.coronium.util.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.function.Function;

import static org.coronium.util.constant.Locator.MODAL_CSS;
import static org.coronium.util.constant.Locator.SPINNER_CSS;

public class ExtraExpectedConditions {
    public static ExpectedCondition<Boolean> invisibilityOfSpinner(){
        return expectedCondition(
            getDriver -> {
                List<WebElement> elements = getDriver.findElements(By.cssSelector(SPINNER_CSS));
                return elements.size() <= 0 ||
                        elements.parallelStream()
                        .noneMatch(WebElement::isDisplayed);
            },
                "Spinnner not to be present or visible");
    }

    public static ExpectedCondition<Boolean> invisibilityOfModal(){
        return expectedCondition(
                getDriver ->{
                    List<WebElement> elements = getDriver.findElements(By.cssSelector(MODAL_CSS));
                    return elements.size() <=0 ||
                            elements.parallelStream().noneMatch(WebElement::isDisplayed);
                },
                "Modal to not be present or visible"
        );
    }

            private static <T> ExpectedCondition<T> expectedCondition(Function<WebDriver, T> function, String string){
                return new ExpectedCondition<T>() {
                    @Override
                    public T apply(WebDriver driver) {
                        return function.apply(driver);
                    }

                    @Override
                    public String toString(){return string; }
                };
        }

}
