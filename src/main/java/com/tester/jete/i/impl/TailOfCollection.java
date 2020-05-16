package com.tester.jete.i.impl;

import com.tester.jete.i.Driver;
import com.tester.jete.i.WebElementsCollection;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @ClassName TailOfCollection
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:59
 */
public class TailOfCollection implements WebElementsCollection {
    private final WebElementsCollection originalCollection;
    private final int size;

    public TailOfCollection(WebElementsCollection originalCollection, int size) {
        this.originalCollection = originalCollection;
        this.size = size;
    }

    @Override
    public List<WebElement> getElements() {
        List<WebElement> source = originalCollection.getElements();
        return source.subList(source.size() - Math.min(source.size(), size), source.size());
    }

    @Override
    public String description() {
        return originalCollection.description() + ".last(" + size + ')';
    }

    @Override
    public Driver driver() {
        return originalCollection.driver();
    }
}

