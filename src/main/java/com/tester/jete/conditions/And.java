package com.tester.jete.conditions;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.WebElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;

@ParametersAreNonnullByDefault
public class And extends Condition {

  private final List<Condition> conditions;
  private Condition lastFailedCondition;

  public And(String name, List<Condition> conditions) {
    super(name);
    this.conditions = conditions;
  }

  @Override
  public boolean apply(Driver driver, WebElement element) {
    lastFailedCondition = null;

    for (Condition c : conditions) {
      if (!c.apply(driver, element)) {
        lastFailedCondition = c;
        return false;
      }
    }
    return true;
  }

  @Override
  public String actualValue(Driver driver, WebElement element) {
    return lastFailedCondition == null ? null : lastFailedCondition.actualValue(driver, element);
  }

  @Override
  public String toString() {
    return lastFailedCondition == null ? super.toString() : lastFailedCondition.toString();
  }
}