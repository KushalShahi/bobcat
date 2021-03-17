package com.adobeclassic.widgets;

import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DialogField;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.Multifield;
import com.cognifide.qa.bb.qualifier.PageObjectInterface;

/**
 * A {@link DialogField} representing a single item of {@link Multifield}
 */
@PageObjectInterface
public interface NewMultifieldItem extends DialogField {

  /**
   * Deletes this item
   */
  void deleteItem();
}
