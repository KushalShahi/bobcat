package com.adobeclassic.widgets.impl;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.NewNumberInput;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.qualifier.PageObject;

/**
 * Default implementation of {@link NumberInput}
 */
@PageObject(css = "coral-numberinput")
public class NumberInput implements NewNumberInput {

  @FindBy(css = "input")
  private WebElement input;

  @FindBy(xpath = Locators.ALTERNATE_LABEL_XPATH)
  private List<WebElement> label;

  @Override
  public void setValue(Object value) {
    input.clear();
    input.sendKeys(String.valueOf(value));
  }

  @Override
  public String getLabel() {
    return label.isEmpty() ? "" : label.get(0).getText();
  }
}