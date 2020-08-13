package org.coronium.util.helper;

import org.coronium.page.AutoPage;
import org.coronium.test.AutoTest;
import org.coronium.util.constant.Time;

import static org.coronium.util.constant.Time.GLOBAL_SCRIPT_TIMEOUT;

public class PageFactory extends org.coronium.page.core.ui.pages.PageFactory{
    public  static <T extends AutoPage> T initElements(Class<T> clazz, long timeoutInSeconds) {
        AutoTest.newWaitWithTimeout(GLOBAL_SCRIPT_TIMEOUT.seconds())
                .until(ExtraExpectedConditions.invisibilityOfSpinner());
        return org.coronium.page.core.ui.pages.PageFactory.initElements(clazz , timeoutInSeconds);
    }

    public static <T extends AutoPage> T initElements(Class<T> clazz){
        return initElements(clazz, Time.GLOBAL_PAGE_LOAD_TIMEOUT.seconds());
    }
}
