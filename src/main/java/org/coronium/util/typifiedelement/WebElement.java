package org.coronium.util.typifiedelement;

import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;


public class WebElement extends TypifiedElement implements Locatable {
    /**
     * Specifies wrapped {@link WebElement}.
     *
     * @param wrappedElement {@code WebElement} to wrap.
     */
    protected WebElement(org.openqa.selenium.WebElement wrappedElement) {
        super(wrappedElement);
    }

    public boolean isActive() {
        return this.getAttribute("class").contains("active");
    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }
}
