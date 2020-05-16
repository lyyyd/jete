package com.tester.jete.i.impl;

import com.tester.jete.i.WebElementsCollection;
import org.openqa.selenium.WebElement;
import com.tester.jete.i.Driver;
import java.util.List;

/**
 * @ClassName HeadOfCollection
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:40
 */
public class HeadOfCollection implements WebElementsCollection {
    private final WebElementsCollection originalCollection;
    private final int size;

    public HeadOfCollection(WebElementsCollection originalCollection, int size) {
        this.originalCollection = originalCollection;
        this.size = size;
    }

    @Override
    public Driver driver() {
        return originalCollection.driver();
    }

    @Override
    public List<WebElement> getElements() {
        List<WebElement> source = originalCollection.getElements();
        return source.subList(0, Math.min(source.size(), size));
    }

    @Override
    public String description() {
        return originalCollection.description() + ".first(" + size + ')';
    }
}
