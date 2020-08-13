package org.coronium.page.core.ui.pages;

import org.coronium.page.AutoPage;

public class PageFactory {

    protected static <T extends AutoPage> T initElements(Class<T> clazz, long timeoutInSeconds) {
        return (T) instantiatePageObject(clazz).get(timeoutInSeconds);
    }

    private static <T extends AutoPage> T instantiatePageObject(Class<T> clazz) {
        try{
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e){
            throw new RuntimeException("Unable to instantiate Page Object", e);
        }
    }
}
