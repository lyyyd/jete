package com.tester.jete.i.impl;

import com.tester.jete.i.Driver;
import com.tester.jete.i.WebElementsCollection;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName WebElementsCollectionWrapper
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 19:00
 */
public class WebElementsCollectionWrapper implements WebElementsCollection {
    private final List<WebElement> elements;
    private final Driver driver;

    public WebElementsCollectionWrapper(Driver driver, Collection<? extends WebElement> elements) {
        this.driver = driver;
        this.elements = new ArrayList<>(elements);
    }

    @Override
    public List<WebElement> getElements() {
        return elements;
    }

    @Override
    public String description() {
        return "$$(" + elements.size() + " elements)";
    }

    @Override
    public Driver driver() {
        return driver;
    }
}