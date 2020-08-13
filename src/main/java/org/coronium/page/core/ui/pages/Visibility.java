package org.coronium.page.core.ui.pages;

import org.coronium.page.core.ui.annotations.ForceVisible;
import org.coronium.page.core.ui.annotations.Invisible;
import org.coronium.page.core.ui.annotations.Visible;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class Visibility {

    private static final List<Class<? extends Annotation>> VISIBILITY_ANNOTATION_CLASSES =
            Arrays.asList(Visible.class, Invisible.class, ForceVisible.class);

    private final Wait<WebDriver> wait;
    private final JavascriptExecutor driver;

    public Visibility(Wait<WebDriver> wait, JavascriptExecutor driver) {
        this.wait = wait;
        this.driver = driver;
    }

    public void waitForAnnotatedElementVisibility(Object pageObject){

        Field[] allFields = pageObject.getClass()
                .getDeclaredFields();

        Arrays.stream(allFields)
                .filter(this::validateFieldVisibilityAnnotations)
                .forEach(field ->
                        invokeWaitFunctionForField(field, pageObject));
    }

    private boolean validateFieldVisibilityAnnotations(Field field) {
        long annotationCount = visibilityAnnotationsFrom(field).count();
        if (annotationCount > 1){
            throw new IllegalArgumentException(String.format(
                    "Field %d on %s has too many Visibility related Annotations",
                    field.getName(),
                    field.getDeclaringClass().getName()));
        } else {
            return annotationCount == 1;
        }
    }

    private Stream<Class<? extends Annotation>> visibilityAnnotationsFrom(Field field) {
        return VISIBILITY_ANNOTATION_CLASSES.stream()
                .filter(field::isAnnotationPresent);
    }

    private void invokeWaitFunctionForField(Field field, Object pageObject) {

    }
}
