package com.tester.jete.conditions;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.impl.Html;

@ParametersAreNonnullByDefault
public class Text extends Condition {
  protected final String text;
  public Text(final String text) {
    super("text");
    this.text = text;
  }

  @Override
  public boolean apply(Driver driver, WebElement element) {
    String elementText = "select".equalsIgnoreCase(element.getTagName()) ?
        getSelectedOptionsTexts(element) :
        element.getText();
    return Html.text.contains(elementText, this.text.toLowerCase());
  }

  private String getSelectedOptionsTexts(WebElement element) {
    List<WebElement> selectedOptions = new Select(element).getAllSelectedOptions();
    StringBuilder sb = new StringBuilder();
    for (WebElement selectedOption : selectedOptions) {
      sb.append(selectedOption.getText());
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return String.format("%s '%s'", getName(), text);
  }
}
