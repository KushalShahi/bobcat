package com.adobeclassic.widgets.impl;

import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.RichTextNew;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.wait.BobcatWait;
import com.google.inject.Inject;

@PageObject(xpath = "//*[contains(@class,'cq-RichText')]/..")
public class RichTextField implements RichTextNew {

	@FindBy(css = ".coral-RichText")
	private WebElement input;

	@FindBy(css = Locators.LABEL_CSS)
	private List<WebElement> label;

	@Inject
	private Actions actions;
	
	 @Inject
	  private BobcatWait bobcatWait;

	@Override
	public void setValue(Object value) {
		try {
//			String text = (String) value;
//			input.click();
//			Thread.sleep(3000);
//			input.sendKeys(text);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
			actions.moveToElement(input);
			input.click();
			bobcatWait.until(elementToBeClickable(input)).click();
			// actions.wait(3000);
			String text = (String) value;
			actions.keyDown(input, CONTROL) //
					.sendKeys("a") //
					.keyUp(CONTROL) //
					.sendKeys(BACK_SPACE);

			List<String> textDividedByLines = Arrays.asList(text.split("\\\\n"));
			for (int i = 0; i < textDividedByLines.size(); i++) {
				if (i != 0) {
					actions.sendKeys(RETURN);
				}
				actions.sendKeys(textDividedByLines.get(i).trim());
			}
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getLabel() {
		return label.isEmpty() ? "" : label.get(0).getText();
	}
}
