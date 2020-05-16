package com.tester.jete.i.impl;

import com.tester.jete.i.Driver;
import com.tester.jete.i.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SelenideElementListProxy
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:50
 */
public class SelenideElementListProxy implements InvocationHandler {

    @SuppressWarnings("unchecked")
    public static List<SelenideElement> wrap(Driver driver, ElementLocator locator) {
        InvocationHandler handler = new SelenideElementListProxy(driver, locator);

        return (List<SelenideElement>) Proxy.newProxyInstance(
                SelenideElementListProxy.class.getClassLoader(), new Class[]{List.class}, handler);
    }

    private final Driver driver;
    private final ElementLocator locator;

    private SelenideElementListProxy(Driver driver, ElementLocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<SelenideElement> elements = new ArrayList<>();
        for (WebElement webElement : locator.findElements()) {
            elements.add(WebElementWrapper.wrap(driver, webElement));
        }
        try {
            return method.invoke(elements, args);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}

