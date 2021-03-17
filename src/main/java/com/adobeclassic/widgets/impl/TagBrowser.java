package com.adobeclassic.widgets.impl;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.NewTagBrowser;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.wait.BobcatWait;
import com.google.inject.Inject;

/**
 * Default implementation of {@link TagBrowser}
 */
@PageObject(xpath = "//*[contains(@class,'js-cq-TagsPickerField')]/..")
public class TagBrowser implements NewTagBrowser {

  @FindBy(css = ".coral-InputGroup-input")
  private WebElement input;

  @FindBy(css = Locators.LABEL_CSS)
  private List<WebElement> label;

  @FindBy(css = ".coral-TagList-tag-removeButton")
  private List<WebElement> removeTagButtons;

  @FindBy(xpath = "(//ul[contains(@class, 'is-visible')]/li[@class='coral-SelectList-item coral-SelectList-item--option'])[1]")
  private WebElement firstResult;

  @Inject
  private BobcatWait bobcatWait;

  @Override
  public void setValue(Object value) {
    List<String> tags = Arrays
        .asList(String.valueOf(value).trim().replaceAll("\\[|\\]|\\s", "").split(","));

    removeTagButtons.forEach((element) -> element.sendKeys(Keys.ENTER));

    tags.forEach((tag) -> {
      input.clear();
      input.sendKeys(" Unilever : " + tag);
      //bobcatWait.until(elementToBeClickable(firstResult)).click();
      input.sendKeys(Keys.ENTER);
    });
  }

  @Override
  public String getLabel() {
    return label.isEmpty() ? "" : label.get(0).getText();
  }
}