package com.adobeclassic.widgets;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DialogField;
import com.cognifide.qa.bb.qualifier.PageObjectInterface;

/**
 * Represents checkbox dialog field.
 */
@PageObjectInterface
public interface NewCheckBox extends DialogField {

  /**
   * Selects the checkbox.
   */
  void select();
}