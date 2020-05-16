package com.tester.jete.i.impl;

import com.tester.jete.i.Driver;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;


/**
 * @ClassName SelenidePageFactory
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:58
 */
public class SelenidePageFactory {
    public <PageObjectClass> PageObjectClass page(Driver driver, Class<PageObjectClass> pageObjectClass) {
        try {
            Constructor<PageObjectClass> constructor = pageObjectClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            return page(driver, constructor.newInstance());
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create new instance of " + pageObjectClass, e);
        }
    }

    public <PageObjectClass, T extends PageObjectClass> PageObjectClass page(Driver driver, T pageObject) {
        initElements(new SelenideFieldDecorator(this, driver, driver.getWebDriver()), pageObject);
        return pageObject;
    }

    /**
     * Similar to the other "initElements" methods, but takes an {@link FieldDecorator} which is used
     * for decorating each of the fields.
     *
     * @param decorator the decorator to use
     * @param page      The object to decorate the fields of
     */
    public void initElements(FieldDecorator decorator, Object page) {
        Class<?> proxyIn = page.getClass();
        while (proxyIn != Object.class) {
            proxyFields(decorator, page, proxyIn);
            proxyIn = proxyIn.getSuperclass();
        }
    }

    private void proxyFields(FieldDecorator decorator, Object page, Class<?> proxyIn) {
        Field[] fields = proxyIn.getDeclaredFields();
        for (Field field : fields) {
            if (isInitialized(page, field)) {
                continue;
            }
            Object value = decorator.decorate(page.getClass().getClassLoader(), field);
            if (value != null) {
                try {
                    field.setAccessible(true);
                    field.set(page, value);
                }
                catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private boolean isInitialized(Object page, Field field) {
        try {
            field.setAccessible(true);
            return field.get(page) != null;
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

