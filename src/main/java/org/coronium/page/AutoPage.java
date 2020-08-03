package org.coronium.page;

import org.coronium.test.AutoTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class AutoPage {
    protected Wait<WebDriver> wait;

    public static WebDriver getDriver() { return AutoTest.getDriver(); }
}
