package com.adobeclassic.widgets.impl;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.NewMultifieldItem;
import com.cognifide.qa.bb.aem.core.component.configuration.FieldConfig;
import com.cognifide.qa.bb.aem.core.component.configuration.MultifieldEntry;
import com.cognifide.qa.bb.aem.core.component.dialog.DialogFieldRetriever;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.qualifier.CurrentScope;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

/**
 * Default implementation of {@link MultifieldItem}
 */
@PageObject(css = "coral-Multifield-input")
public class MultifieldItem implements NewMultifieldItem {

  @Inject
  private DialogFieldRetriever dialogFieldRetriever;

  @Inject
  @CurrentScope
  private WebElement item;

  @FindBy(css = "button.coral-Multifield-remove")
  private WebElement deleteButton;

  @FindBy(css = Locators.LABEL_CSS)
  private List<WebElement> label;

  @Override
  public void setValue(Object value) {
    MultifieldEntry entry = (MultifieldEntry) value;
    entry.getItem().forEach(this::setFieldInMultifield);
  }

  @Override
  public void deleteItem() {
    deleteButton.click();
  }

  private void setFieldInMultifield(FieldConfig fieldConfig) {
    dialogFieldRetriever.getDialogField(item, fieldConfig.getLabel(), fieldConfig.getType())
        .setValue(fieldConfig.getValue());
  }

  @Override
  public String getLabel() {
    return label.isEmpty() ? "" : label.get(0).getText();
  }
}