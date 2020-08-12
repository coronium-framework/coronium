package org.coronium.page.core.ui.pages;

import org.coronium.page.AutoPage;

public class PageFactory {

    private static <T extends AutoPage> T instantiatePageObject(Class<T> clazz) {
        try{
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e){
            throw new RuntimeException("Unable to instantiate Page Object", e);
        }
    }
}
