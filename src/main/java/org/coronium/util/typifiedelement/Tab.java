package org.coronium.util.typifiedelement;

import org.openqa.selenium.By;

public class Tab extends WebElement {

    private final String ANCESTOR_CSS = "#primary-navbar-collapse > ul > li";

    protected Tab(org.openqa.selenium.WebElement wrappedElement) {
        super(wrappedElement);
    }

    private org.openqa.selenium.WebElement getTab(){
        return this.getWrappedElement()
                .findElement(By.cssSelector(ANCESTOR_CSS));
    }
}
