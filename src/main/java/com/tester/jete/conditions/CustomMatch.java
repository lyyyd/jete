package com.tester.jete.conditions;

import java.util.function.Predicate;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.WebElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;

@ParametersAreNonnullByDefault
public class CustomMatch extends Condition {
  protected final Predicate<WebElement> predicate;

  public CustomMatch(String description, Predicate<WebElement> predicate) {
    super(description);
    this.predicate = predicate;
  }

  @Override
  public boolean apply(Driver driver, WebElement element) {
    return predicate.test(element);
  }


  @Override
  public String toString() {
    return String.format("match '%s' predicate.", getName());
  }
}
