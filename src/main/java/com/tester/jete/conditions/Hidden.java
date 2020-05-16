package com.tester.jete.conditions;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.tester.jete.Condition;
import com.tester.jete.i.Driver;

@ParametersAreNonnullByDefault
public class Hidden extends Condition {
  public Hidden() {
    super("hidden", true);
  }

  @Override
  public boolean apply(Driver driver, WebElement element) {
    try {
      return !element.isDisplayed();
    }
    catch (StaleElementReferenceException elementHasDisappeared) {
      return true;
    }
  }

  @Nonnull
  @Override
  public Condition negate() {
    return new Not(this, false);
  }
}
