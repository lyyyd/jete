package com.tester.jete.conditions;

import java.util.regex.Pattern;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.WebElement;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;

@ParametersAreNonnullByDefault
public class MatchAttributeWithValue extends Condition {
  private final String attributeName;
  private final Pattern attributeRegex;

  public MatchAttributeWithValue(String attributeName, String attributeRegex) {
    super("match attribute");
    this.attributeName = attributeName;
    this.attributeRegex = Pattern.compile(attributeRegex);
  }

  @Override
  public boolean apply(Driver driver, WebElement element) {
    return attributeRegex.matcher(getAttributeValue(element)).matches();
  }

  @Override
  public String actualValue(Driver driver, WebElement element) {
    return String.format("%s=\"%s\"", attributeName, getAttributeValue(element));
  }

  @Override
  public String toString() {
    return String.format("%s %s=\"%s\"", getName(), attributeName, attributeRegex);
  }

  private String getAttributeValue(WebElement element) {
    String attr = element.getAttribute(attributeName);
    return attr == null ? "" : attr;
  }
}
