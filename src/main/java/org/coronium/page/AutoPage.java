package org.coronium.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.coronium.page.core.ui.common.reporting.allure.AllureLogger;
import org.coronium.page.core.ui.js.JavascriptWait;
import org.coronium.page.core.ui.pages.Visibility;
import org.coronium.test.AutoTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


public class AutoPage<T extends AutoPage> {

    protected final WebDriver driver;
    protected Wait<WebDriver> wait;
    protected Visibility visibility;
    protected JavascriptWait javascriptWait;
    protected final Logger logger = LogManager.getLogger(this);

    public AutoPage(){
        driver = AutoTest.getDriver();
        wait = AutoTest.getWait();
        visibility = new Visibility(wait, (JavascriptExecutor) AutoTest.getDriver());
        javascriptWait = new JavascriptWait(driver, wait);
    }

    public static WebDriver getDriver() { return AutoTest.getDriver(); }

    /**
     * @return the current page object.
     * Useful for e.g. MyPage.get().then().doSomething();
     */
    @SuppressWarnings("unchecked")
    public T then() {
        return (T) this;
    }


    /**
     * @return the current page object.
     * Useful for e.g. MyPage.get().then().with().aComponent().clickHome();
     */
    @SuppressWarnings("unchecked")
    public T with() {
        return (T) this;
    }

    public T get(long timeoutInSeconds) {
        updatePageTimeout(timeoutInSeconds);
        return (T) get();
    }


    public T get(String url) {
        driver.get(url);
        return (T) get();
    }

    public T get(String url, long timeout) {
        updatePageTimeout(timeout);
        return get(url);
    }

    public T get(){
        HtmlElementLoader.populatePageObject(this,getDriver());
        visibility.waitForAnnotatedElementVisibility(this);
        javascriptWait.waitForJavascriptEventsOnLoad();

        return (T) this;
    }

    private void logPageLoadToAllure() {
        try {
            AllureLogger.logToAllure("Page '" + getClass().getName() + "' successfully loaded");
        } catch (Exception e) {
            logger.warn("Error logging page load, but loaded successfully", e);
        }
    }

    private void updatePageTimeout(long timeoutInSeconds) {
        wait = AutoTest.newWaitWithTimeout(timeoutInSeconds);
        visibility = new Visibility(wait, (JavascriptExecutor) AutoTest.getDriver());
        javascriptWait = new JavascriptWait(driver, wait);
    }
}
