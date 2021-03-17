package com.adobeclassic.widgets.impl;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.CtaLabelField;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.qualifier.CurrentScope;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

/**
 * Default implementation of {@link CtaLabel}
 */
@PageObject(xpath = "//*[contains(@class,'coral-Textfield')]/..")
public class CtaLabel implements CtaLabelField {

	@FindBy(css = ".coral-Textfield")
	private WebElement ctalabelinput;

	@FindBy(css = Locators.LABEL_CSS)
	private List<WebElement> label;

	@Override
	public void setValue(Object value) {
		ctalabelinput.clear();
		ctalabelinput.sendKeys(String.valueOf(value));
		
	}

	@Override
	public String getLabel() {
		return label.isEmpty() ? "" : label.get(0).getText();
	}

}