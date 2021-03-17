package com.adobeclassic.widgets;


import com.adobeclassic.widgets.NewMultifieldItem;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DialogField;
import com.cognifide.qa.bb.qualifier.PageObjectInterface;

/**
 * This class represents TouchUI dialog multifield.
 */
@PageObjectInterface
public interface NewMultiField extends DialogField {

  /**
   * Returns MultifieldItem at declared index position
   *
   * @param index integer representing required position
   * @return MultifieldItem
   */

  NewMultifieldItem getItemAtIndex(int index);

  /**
   * Adds a new {@link MultifieldItem}.
   */
  void addField();
}
