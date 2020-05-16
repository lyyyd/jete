package com.tester.jete.conditions;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.WebElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.impl.Html;

@ParametersAreNonnullByDefault
public class MatchText extends Condition {
  private final String regex;

  public MatchText(String regex) {
    super("match text");
    this.regex = regex;
  }

  @Override
  public boolean apply(Driver driver, WebElement element) {
    return Html.text.matches(element.getText(), regex);
  }

  @Override
  public String toString() {
    return String.format("%s '%s'", getName(), regex);
  }
}
