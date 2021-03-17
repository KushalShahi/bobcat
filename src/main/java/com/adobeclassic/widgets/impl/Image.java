package com.adobeclassic.widgets.impl;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adobeclassic.widgets.NewImage;
import com.cognifide.qa.bb.aem.core.component.configuration.TabConfig;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Locators;
import com.cognifide.qa.bb.aem.core.sidepanel.internal.SidePanel;
import com.cognifide.qa.bb.aem.core.sidepanel.internal.SidePanelTabs;
import com.cognifide.qa.bb.dragdrop.DragAndDropFactory;
import com.cognifide.qa.bb.dragdrop.Draggable;
import com.cognifide.qa.bb.dragdrop.Droppable;
import com.cognifide.qa.bb.qualifier.FindPageObject;
import com.cognifide.qa.bb.qualifier.Global;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.scope.frame.FramePath;
import com.google.inject.Inject;

/**
 * Default implementation of {@link Image}
 */
@PageObject(xpath = "//*[contains(@class,'cq-AssetPickerField')]/..")
public class Image implements NewImage {

  @Inject
  private DragAndDropFactory dragAndDropFactory;

  @Global
  @FindPageObject
  private SidePanel sidePanel;

  @FindBy(css = ".cq-FileUpload-thumbnail")
  private WebElement dropArea;

  @FindBy(css = Locators.LABEL_CSS)
  private List<WebElement> label;

  @Override
  public void setValue(Object value) {
    sidePanel.selectTab(SidePanelTabs.ASSETS.getCssClass());
    Draggable draggable = sidePanel.searchForAsset(String.valueOf(value));
    Droppable droppable = dragAndDropFactory.createDroppable(dropArea, FramePath.parsePath("/"));
    draggable.dropTo(droppable);
   
  }

  @Override
  public String getLabel() {
    return label.isEmpty() ? "" : label.get(0).getText();
  }
}