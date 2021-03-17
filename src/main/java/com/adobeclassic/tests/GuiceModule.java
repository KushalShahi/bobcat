package com.adobeclassic.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobeclassic.tests.pageobjects.TextComponent;
import com.adobeclassic.tests.pageobjects.TextComponentImpl;
import com.adobeclassic.widgets.BrowseImageDam;
import com.adobeclassic.widgets.CtaLabelField;
import com.adobeclassic.widgets.NewCheckBox;
import com.adobeclassic.widgets.NewDropdown;
import com.adobeclassic.widgets.NewImage;
import com.adobeclassic.widgets.NewMultiField;
import com.adobeclassic.widgets.NewMultifieldItem;
import com.adobeclassic.widgets.NewNumberInput;
import com.adobeclassic.widgets.NewPathBrowser;
import com.adobeclassic.widgets.NewPlainText;
import com.adobeclassic.widgets.NewRadioGroup;
import com.adobeclassic.widgets.NewTagBrowser;
import com.adobeclassic.widgets.NewTextField;
import com.adobeclassic.widgets.RichTextNew;
import com.adobeclassic.widgets.impl.Checkbox;
import com.adobeclassic.widgets.impl.CtaLabel;
import com.adobeclassic.widgets.impl.DropdownField;
import com.adobeclassic.widgets.impl.Image;
import com.adobeclassic.widgets.impl.ImagePathBrowse;
import com.adobeclassic.widgets.impl.Multifield;
import com.adobeclassic.widgets.impl.MultifieldItem;
import com.adobeclassic.widgets.impl.NumberInput;
import com.adobeclassic.widgets.impl.PathBrowser;
import com.adobeclassic.widgets.impl.PlainTextfield;
import com.adobeclassic.widgets.impl.RadioGroup;
import com.adobeclassic.widgets.impl.RichTextField;
import com.adobeclassic.widgets.impl.TagBrowser;
import com.adobeclassic.widgets.impl.Textfield;
import com.cognifide.qa.bb.aem.core.api.AemActions;
import com.cognifide.qa.bb.aem.core.component.actions.EditComponent;
import com.cognifide.qa.bb.aem.core.component.dialog.dialogfields.DialogField;
import com.cognifide.qa.bb.aem.core.modules.AemComponentModule;
import com.cognifide.qa.bb.aem.core.modules.fields.FieldsRegistryModule;
import com.cognifide.qa.bb.api.actions.ActionWithData;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class GuiceModule extends AbstractModule {
	private static final Logger LOG = LoggerFactory.getLogger(FieldsRegistryModule.class);
	private static final Logger LOGS = LoggerFactory.getLogger(AemComponentModule.class);

	@Override
	protected void configure() {
		LOG.debug("Configuring Bobcat module: {}", getClass().getSimpleName());

		LOG.debug("Registering dialog fields...");
		bind(TextComponent.class).to(TextComponentImpl.class);
		bind(RichTextNew.class).to(RichTextField.class);
		bind(NewDropdown.class).to(DropdownField.class);
		bind(NewCheckBox.class).to(Checkbox.class);
		bind(NewImage.class).to(Image.class);
		bind(NewMultiField.class).to(Multifield.class);
		bind(NewMultifieldItem.class).to(MultifieldItem.class);
		bind(NewNumberInput.class).to(NumberInput.class);
		bind(NewPathBrowser.class).to(PathBrowser.class);
		bind(NewRadioGroup.class).to(RadioGroup.class);
		bind(NewTagBrowser.class).to(TagBrowser.class);
		bind(NewTextField.class).to(Textfield.class);
		bind(CtaLabelField.class).to(CtaLabel.class);
		bind(NewPlainText.class).to(PlainTextfield.class);
		bind(BrowseImageDam.class).to(ImagePathBrowse.class);

		MapBinder<String, DialogField> fieldsBinder = MapBinder.newMapBinder(binder(), String.class, DialogField.class);
		registerField(fieldsBinder, NewFields.RICHTEXT_AC, RichTextField.class);
		registerField(fieldsBinder, NewFields.DROPDOWN_AC, DropdownField.class);
		registerField(fieldsBinder, NewFields.CHECKBOX_AC, Checkbox.class);
		registerField(fieldsBinder, NewFields.IMAGE_AC, Image.class);
		registerField(fieldsBinder, NewFields.MULTIFIELD_AC, Multifield.class);
		registerField(fieldsBinder, NewFields.MULTIFIELD_ITEM_AC, MultifieldItem.class);
		registerField(fieldsBinder, NewFields.NUMBER_INPUT_AC, NumberInput.class);
		registerField(fieldsBinder, NewFields.PATHBROWSER_AC, PathBrowser.class);
		registerField(fieldsBinder, NewFields.RADIO_GROUP_AC, RadioGroup.class);
		registerField(fieldsBinder, NewFields.TAGBROWSER_AC, TagBrowser.class);
		registerField(fieldsBinder, NewFields.TEXTFIELD_AC, Textfield.class);
		registerField(fieldsBinder, NewFields.CTALABEL_AC, CtaLabel.class);
		registerField(fieldsBinder, NewFields.PLAINTEXTFIELD_AC, PlainTextfield.class);
		registerField(fieldsBinder, NewFields.IMAGEBROWSE_AC, ImagePathBrowse.class);

		LOGS.debug("Configuring Bobcat module: {}", getClass().getSimpleName());
		bindComponentActions();
		// bind(ComponentToolbar.class).to(ComponentToolbarImpl.class);
		bind(ConfigDialogAdobeClassic.class).to(ConfigDialogAdobeClassicImpl.class);
		// bind(DialogFieldRetriever.class).to(DefaultDialogFieldRetriever.class);
		// bindCommonToolbarOptions();

	}

	private void registerField(MapBinder<String, DialogField> binder, String name, Class<? extends DialogField> type) {
		LOG.debug("- registering field: {} [{}]", name, type);
		binder.addBinding(name).to(type);
	}

	private void bindComponentActions() {
		MapBinder<String, ActionWithData> componentActions = MapBinder.newMapBinder(binder(), String.class,
				ActionWithData.class);
		// componentActions.addBinding(AemActions.EDIT_COMPONENT).to(EditComponent.class);
		componentActions.addBinding(AemActionsAdobeClassic.CONFIGURE_COMPONENT_ADOBECLASSIC)
				.to(ConfigureComponentAdobeClassic.class);
	}

//	private void bindCommonToolbarOptions() {
//		MapBinder<String, ToolbarOption> toolbarOptions = MapBinder.newMapBinder(binder(), String.class,
//				ToolbarOption.class);
//		Arrays.stream(CommonToolbarOptions.values()).forEach(option -> toolbarOptions.addBinding(option.getTitle())
//				.toInstance(new CommonToolbarOption(option.getTitle())));
//	}
}
