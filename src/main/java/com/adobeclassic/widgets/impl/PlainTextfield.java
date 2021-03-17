package com.adobeclassic.widgets.impl;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.NewPlainText;
import com.adobeclassic.widgets.NewTextField;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.qualifier.CurrentScope;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

/**
 * Default implementation of {@link PlainTextfield}
 */
@PageObject(xpath = "//*[contains(@class,'coral-Textfield')]/..")
public class PlainTextfield implements NewPlainText {

//	@Inject
//	@CurrentScope
	@FindBy(css = ".coral-Textfield")
	private WebElement input;

	@FindBy(css = Locators.LABEL_CSS)
	private List<WebElement> label;
	
	@Inject
	private Actions actions;

	@Override
	public void setValue(Object value) {
		input.clear();
//		input.sendKeys(String.valueOf(value));
		actions.sendKeys(input, String.valueOf(value));
		actions.perform();
	}

	@Override
	public String getLabel() {
		return label.isEmpty() ? "" : label.get(0).getText();
	}
}