package com.tester.jete.i.impl;

import com.tester.jete.i.SelenideElement;
import com.tester.jete.i.WebElementsCollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName SelenideElementIterator
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:49
 */
public class SelenideElementIterator implements Iterator<SelenideElement> {
    protected final WebElementsCollection collection;
    protected int index;

    public SelenideElementIterator(WebElementsCollection collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return collection.getElements().size() > index;
    }

    @Override
    public SelenideElement next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return CollectionElement.wrap(collection, index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from web page");
    }
}
