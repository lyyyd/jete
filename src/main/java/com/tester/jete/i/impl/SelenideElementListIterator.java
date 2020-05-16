package com.tester.jete.i.impl;

import com.tester.jete.i.SelenideElement;
import com.tester.jete.i.WebElementsCollection;

import java.util.ListIterator;

/**
 * @ClassName SelenideElementListIterator
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:50
 */
public class SelenideElementListIterator extends SelenideElementIterator implements ListIterator<SelenideElement> {
    public SelenideElementListIterator(WebElementsCollection collection, int index) {
        super(collection);
        this.index = index;
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public SelenideElement previous() {
        return CollectionElement.wrap(collection, --index);
    }

    @Override
    public int nextIndex() {
        return index + 1;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void set(SelenideElement selenideElement) {
        throw new UnsupportedOperationException("Cannot set elements to web page");
    }

    @Override
    public void add(SelenideElement selenideElement) {
        throw new UnsupportedOperationException("Cannot add elements to web page");
    }
}

