package com.adobeclassic.tests.pageobjects;

import com.cognifide.qa.bb.constants.HtmlTags;
import com.cognifide.qa.bb.constants.HtmlTags.Properties;
import com.cognifide.qa.bb.qualifier.CurrentScope;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;
import org.openqa.selenium.WebElement;

@PageObject(css = ".cmp-text")
public class TextComponentImpl implements TextComponent {

	@Inject
	@CurrentScope
	private WebElement component;

	public String getInnerHTML() {
		return component.getAttribute(Properties.INNER_HTML);
	}

	public String getCssClassNameProperty() {
		return component.getAttribute(HtmlTags.Properties.CLASS_NAME);
	}

}
