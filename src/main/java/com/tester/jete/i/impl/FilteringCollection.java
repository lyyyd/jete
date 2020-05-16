package com.tester.jete.i.impl;
import com.tester.jete.i.Driver;
import com.tester.jete.i
import com.tester.jete.i.WebElementsCollection;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName FilteringCollection
 * @Description TODO
 * @Author David.Jackson.Lyd@gmail.com
 * @Date: 2020/05/16 18:22
 */
public class FilteringCollection implements WebElementsCollection {
    private final WebElementsCollection originalCollection;
    private final Predicate<WebElement> filter;

    public FilteringCollection(WebElementsCollection originalCollection, Predicate<WebElement> filter) {
        this.originalCollection = originalCollection;
        this.filter = filter;
    }

    public FilteringCollection(WebElementsCollection originalCollection, Condition filter) {
        this.originalCollection = originalCollection;
        this.filter = new ConditionPredicate(driver(), filter);
    }

    @Override
    public List<WebElement> getElements() {
        return originalCollection.getElements().stream().filter(filter).collect(toList());
    }

    @Override
    public String description() {
        return originalCollection.description() + ".filter(" + filter + ')';
    }

    @Override
    public Driver driver() {
        return originalCollection.driver();
    }

    private static class ConditionPredicate implements Predicate<WebElement> {
        private final Driver driver;
        private final Condition filter;

        private ConditionPredicate(Driver driver, Condition filter) {
            this.driver = driver;
            this.filter = filter;
        }

        @Override
        public boolean test(@Nullable WebElement webElement) {
            return filter.apply(driver, webElement);
        }

        @Override
        public String toString() {
            return filter.toString();
        }
    }
}
