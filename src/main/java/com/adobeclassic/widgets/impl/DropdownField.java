package com.adobeclassic.widgets.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.NewDropdown;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.qualifier.CurrentScope;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;;

/**
 * Default implementation of {@link NewDropdown}
 */
@PageObject(xpath = "//*[contains(@class,'coral-Select')]/..")
public class DropdownField implements NewDropdown {

	private static final String SELECT_OPTIONS_CSS = ".coral-SelectList-item";
	//private static final String DROPDOWN_VALUES_CSS = "ul.coral-SelectList.is-visible";

	@Inject
	@CurrentScope
	private WebElement selectField;

	@Inject
	private Actions actions;

	@FindBy(css = Locators.LABEL_CSS)
	private List<WebElement> label;

	@Override
	public void setValue(Object value) {
		selectField.isEnabled();
		actions.moveToElement(selectField).click().perform();
		//List<WebElement> dropdownValues = selectField.findElements(By.cssSelector(DROPDOWN_VALUES_CSS));
		List<WebElement> options = selectField.findElements(By.cssSelector(SELECT_OPTIONS_CSS));
		options.stream().filter(o -> value.toString().equals(o.getText())).findFirst().orElseThrow(
				() -> new NoSuchElementException(String.format("Option with text %s not found", value.toString())))
				.click();

	}

	@Override
	public String getLabel() {
		return label.isEmpty() ? "" : label.get(0).getText();
	}
}