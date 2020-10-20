package org.coronium.page.core.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.coronium.page.AutoPage;

import java.lang.reflect.InvocationTargetException;

public class PageFactory {

    private static final Logger logger = LogManager.getLogger();

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
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            logger.fatal("Unable to instantiate PageObject", e);
            throw new IllegalStateException("Unable to instantiate PageObject", e);
        }
    }
}
