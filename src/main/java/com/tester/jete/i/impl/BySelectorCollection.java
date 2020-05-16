package com.tester.jete.i.impl;

import java.util.List;

import com.tester.jete.i.WebElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;

public class BySelectorCollection implements WebElementsCollection {

  private final Driver driver;
  private final SearchContext parent;
  private final By selector;

  public BySelectorCollection(Driver driver, By selector) {
    this(driver, null, selector);
  }

  public BySelectorCollection(Driver driver, SearchContext parent, By selector) {
    this.driver = driver;
    this.parent = parent;
    this.selector = selector;
  }

  @Override
  public List<WebElement> getElements() {
    SearchContext searchContext = parent == null ? driver.getWebDriver() : parent;
    return WebElementSelector.instance.findElements(driver, searchContext, selector);
  }

  @Override
  public String description() {
    return parent == null ? Describe.selector(selector) :
        (parent instanceof SelenideElement) ?
            ((SelenideElement) parent).getSearchCriteria() + "/" + Describe.shortly(selector) :
            Describe.shortly(selector);
  }

  @Override
  public Driver driver() {
    return driver;
  }
}
