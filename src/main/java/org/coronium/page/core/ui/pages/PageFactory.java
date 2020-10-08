package org.coronium.page.core.ui.pages;

import org.coronium.page.AutoPage;

public class PageFactory {

    public static <T extends AutoPage> T newInstance(Class<T> clazz) {

        return (T) instantiatePageObject(clazz).get();
    }

    public static <T extends AutoPage> T newInstance(
            Class<T> clazz, long timeoutInSeconds) {

        return (T) instantiatePageObject(clazz).get(timeoutInSeconds);
    }

    public static <T extends AutoPage> T newInstance(
            Class<T> clazz, String url) {

        return (T) instantiatePageObject(clazz).get(url);
    }

    public static <T extends AutoPage> T newInstance(
            Class<T> clazz, String url, long timeoutInSeconds) {

        return (T) instantiatePageObject(clazz).get(url, timeoutInSeconds);
    }


    private static <T extends AutoPage> T instantiatePageObject(Class<T> clazz) {
        try{
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e){
            throw new RuntimeException("Unable to instantiate Page Object", e);
        }
    }
}
