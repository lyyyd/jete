package com.tester.jete.conditions;

import static java.util.stream.Collectors.joining;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.WebElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;

@ParametersAreNonnullByDefault
public class Or extends Condition {

  private final List<Condition> conditions;

  public Or(String name, List<Condition> conditions) {
    super(name);
    this.conditions = conditions;
  }

  @Override
  public boolean apply(Driver driver, WebElement element) {
    for (Condition c : conditions) {
      if (c.apply(driver, element)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String actualValue(Driver driver, WebElement element) {
    return conditions.stream().map(condition -> condition.actualValue(driver, element)).collect(joining(", "));
  }

  @Override
  public String toString() {
    String conditionsToString = conditions.stream().map(Condition::toString).collect(joining(" or "));
    return String.format("%s: %s", getName(), conditionsToString);
  }
}
