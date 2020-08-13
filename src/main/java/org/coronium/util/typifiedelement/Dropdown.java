package org.coronium.util.typifiedelement;

import org.openqa.selenium.By;

import java.util.List;

public class Dropdown extends WebElement {
    private final String ANCESTOR_CSS = "a[class='dropdown-toggle']";
    private final String OPTIONS_CSS = "ul.dropdown-menu > li";

    protected Dropdown(org.openqa.selenium.WebElement wrappedElement) {
        super(wrappedElement);
    }

    private org.openqa.selenium.WebElement getDropdown(){
        return this.getWrappedElement()
                .findElement(By.cssSelector(ANCESTOR_CSS));
    }

    private List<org.openqa.selenium.WebElement> getOptions(){
        return getDropdown().findElements(By.cssSelector(OPTIONS_CSS));
    }
}
