package com.tester.jete.conditions;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.WebElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;

@ParametersAreNonnullByDefault
public class Enabled extends Condition {

  public Enabled() {
    super("enabled");
  }

  @Override
  public boolean apply(Driver driver, WebElement element) {
    return element.isEnabled();
  }

  @Override
  public String actualValue(Driver driver, WebElement element) {
    return element.isEnabled() ? "enabled" : "disabled";
  }
}
