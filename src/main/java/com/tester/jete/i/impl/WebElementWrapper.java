package com.tester.jete.i.impl;

import com.tester.jete.i.Driver;
import com.tester.jete.i.SelenideElement;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Proxy;

/**
 * @ClassName WebElementWrapper
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:52
 */
public class WebElementWrapper extends WebElementSource {
    public static SelenideElement wrap(Driver driver, WebElement element) {
        return element instanceof SelenideElement ?
                (SelenideElement) element :
                (SelenideElement) Proxy.newProxyInstance(
                        element.getClass().getClassLoader(), new Class<?>[]{SelenideElement.class},
                        new SelenideElementProxy(new WebElementWrapper(driver, element)));
    }

    private final Driver driver;
    private final WebElement delegate;

    protected WebElementWrapper(Driver driver, WebElement delegate) {
        this.driver = driver;
        this.delegate = delegate;
    }

    @Override
    public WebElement getWebElement() {
        return delegate;
    }

    @Override
    public String getSearchCriteria() {
        return Describe.shortly(driver, delegate);
    }

    @Override
    public String toString() {
        return Describe.describe(driver(), delegate);
    }

    @Override
    public Driver driver() {
        return driver;
    }
}
