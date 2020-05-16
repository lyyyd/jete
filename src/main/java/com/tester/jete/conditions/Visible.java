package com.tester.jete.conditions;

import javax.annotation.Nonnull;

import org.openqa.selenium.WebElement;
import com.tester.jete.Condition;
import com.tester.jete.i.Driver;

public class Visible extends Condition {
  public Visible() {
    super("visible");
  }

  @Override
  public boolean apply(Driver driver, WebElement element) {
    return element.isDisplayed();
  }

  @Override
  public String actualValue(Driver driver, WebElement element) {
    return String.format("visible:%s", element.isDisplayed());
  }

  @Nonnull
  @Override
  public Condition negate() {
    return new Not(this, true);
  }
}
