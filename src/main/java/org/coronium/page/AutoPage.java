package org.coronium.page;

import org.coronium.page.core.ui.js.JavascriptWait;
import org.coronium.page.core.ui.pages.Visibility;
import org.coronium.test.AutoTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


public class AutoPage {

    protected final WebDriver driver;
    protected Wait<WebDriver> wait;
    protected Visibility visibility;
    protected JavascriptWait javascriptWait;

    public AutoPage() {
        driver = AutoTest.getDriver();
        wait = AutoTest.getWait();
        visibility = new Visibility(wait, (JavascriptExecutor) AutoTest.getDriver());
    }

    public static WebDriver getDriver() { return AutoTest.getDriver(); }

    public AutoPage get(long timeoutInSeconds) {
        updatePageTimeout(timeoutInSeconds);
        return get();
    }

    public AutoPage get(String url) {
        driver.get(url);
        return get();
    }

    public AutoPage get(String url, long timeout) {
        updatePageTimeout(timeout);
        return get(url);
    }

    public AutoPage get(){
        HtmlElementLoader.populatePageObject(this,getDriver());
        visibility.waitForAnnotatedElementVisibility(this);
        javascriptWait.waitForJavascriptEventsOnLoad();

        return (AutoPage) this;
    }

    private void updatePageTimeout(long timeoutInSeconds) {
        wait = AutoTest.newWaitWithTimeout(timeoutInSeconds);
        visibility = new Visibility(wait, (JavascriptExecutor) AutoTest.getDriver());
        javascriptWait = new JavascriptWait(driver, wait);
    }
}
