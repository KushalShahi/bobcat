package com.adobeclassic.tests;

import com.cognifide.qa.bb.aem.core.component.configuration.ComponentConfiguration;
import com.cognifide.qa.bb.aem.core.component.dialog.ConfigDialog;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DialogField;
import com.cognifide.qa.bb.qualifier.PageObjectInterface;

/**
 * Represents the component's configuration dialog
 */
@PageObjectInterface
public interface ConfigDialogAdobeClassic {

  /**
   * Verify if the dialog is displayed
   */
  void verifyIsDisplayed();

  /**
   * Verify if the dialog is hidden
   */
  void verifyIsHidden();

  /**
   * Verify if the dialog in in fullscreen mode
   */
  void verifyFullscreen();

  /**
   * Confirm the dialog
   */
  void confirm();

  /**
   * Toggles the fullscreen mode
   */
  void toggleFullscreen();

  /**
   * Configures the dialog with provided data.
   *
   * @param config an instance of {@link ComponentConfiguration} holding the desired data
   */
  void configureWith(ComponentConfiguration config);

  /**
   * Retrieves a field from the provided tab in the dialog based on its label and type
   *
   * @param label     label of the field
   * @param tab       tab in which the field is expected to be
   * @param fieldType type of field
   * @return a {@link DialogField} described by provided info
   */
  DialogField getFieldOnTab(String label, String tab, String fieldType);

  /**
   * Sets a value in a field described by provided data
   *
   * @param label     label of the field
   * @param fieldType type of the field
   * @param value     value to be set in the field
   * @return self-reference
   */
  ConfigDialogAdobeClassic setField(String label, String fieldType, Object value);

  /**
   * Retrieves a field from the dialog based on its label and type
   *
   * @param label     label of the field
   * @param fieldType type of the field
   * @return a {@link DialogField} representing the requested field
   */
  DialogField getField(String label, String fieldType);

  /**
   * Switches to the provided tab
   *
   * @param tabLabel label of the tab to switch to
   * @return self-reference
   */
  ConfigDialogAdobeClassic switchTab(String tabLabel);
}
