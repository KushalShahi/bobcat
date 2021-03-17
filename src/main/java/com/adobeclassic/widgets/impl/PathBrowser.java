package com.adobeclassic.widgets.impl;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.NewPathBrowser;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.wait.BobcatWait;
import com.google.inject.Inject;

/**
 * Default implementation of {@link PathBrowser}
 */
@PageObject(xpath = "//*[contains(@class,'coral-PathBrowser')]/..")
public class PathBrowser implements NewPathBrowser {

  @FindBy(css = ".js-coral-pathbrowser-input")
  private WebElement input;

  @FindBy(css = Locators.LABEL_CSS)
  private List<WebElement> label;

  @FindBy(xpath = "(//ul[contains(@class, 'is-visible')]/li[@class='coral-SelectList-item coral-SelectList-item--option'])[1]")
  private WebElement firstResult;

  @Inject
  private BobcatWait bobcatWait;

  @Override
  public void setValue(Object value) {
    input.clear();
    input.sendKeys(String.valueOf(value));
    bobcatWait.until(elementToBeClickable(firstResult));
    firstResult.click();
   // input.sendKeys(Keys.ENTER);
  }

  @Override
  public String getLabel() {
    return label.isEmpty() ? "" : label.get(0).getText();
  }
}