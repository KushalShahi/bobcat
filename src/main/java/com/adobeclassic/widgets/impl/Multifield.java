package com.adobeclassic.widgets.impl;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.NewMultiField;
import com.adobeclassic.widgets.NewMultifieldItem;
import com.cognifide.qa.bb.aem.core.component.configuration.MultifieldEntry;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.exceptions.BobcatRuntimeException;
import com.cognifide.qa.bb.qualifier.FindPageObject;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/**
 * Default implementation of {@link Multifield}
 */
@PageObject(css = "//*[contains(@class,'coral-Multifield')]/..")
public class Multifield implements NewMultiField {

  @FindBy(css = "button.coral-Multifield-add")
  private WebElement addButton;

  @FindPageObject
  private List<NewMultifieldItem> items;

  @FindBy(xpath = Locators.ALTERNATE_LABEL_XPATH)
  private List<WebElement> label;

  @Override
  public void setValue(Object value) {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    List<MultifieldEntry> cfg =
        mapper.convertValue(value, new TypeReference<List<MultifieldEntry>>() {
        });

    while(items.size() < cfg.size()) {
      addField();
    }

    Iterator<NewMultifieldItem> itemsIterator = items.iterator();
    cfg.forEach(entry -> itemsIterator.next().setValue(entry));
  }

  @Override
  public String getLabel() {
    return label.isEmpty() ? "" : label.get(0).getText();
  }

  @Override
  public void clearField() {
    items.forEach(NewMultifieldItem::deleteItem);
  }

  @Override
  public NewMultifieldItem getItemAtIndex(int index) {
    int itemsSize = items.size();
    if (itemsSize > index) {
      return items.get(index);
    }
    throw new BobcatRuntimeException(String
        .format("Tried to get item at index %s but there are only %s elements", index, itemsSize));
  }

  @Override
  public void addField() {
    addButton.click();
  }
}