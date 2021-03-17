package com.adobeclassic.widgets.impl;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.NewCheckBox;
import com.cognifide.qa.bb.qualifier.PageObject;

/**
 * Default implementation of {@link Checkbox}
 */
@PageObject(xpath = "//*[contains(@class,'coral-Checkbox-input')]/..")
public class Checkbox implements NewCheckBox {

	@FindBy(css = ".coral-Checkbox-checkmark")
	private WebElement checkboxElement;

	@FindBy(css = ".coral-Checkbox-description")
	private List<WebElement> label;

	@Override
	public void select() {
		checkboxElement.click();
	}

	@Override
	public void setValue(Object value) {
		if (Boolean.valueOf(String.valueOf(value)) != checkboxElement.isSelected()) {
			select();
		}
	}

	@Override
	public String getLabel() {
		return label.isEmpty() ? "" : label.get(0).getText();
	}
}