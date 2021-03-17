package com.adobeclassic.qa.tests.templates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import unilever.regressiontest.pageobjects.RichTextV2Component;
import com.cognifide.qa.bb.aem.core.modules.AemComponentModule;
import com.adobeclassic.tests.AemActionsAdobeClassic;
import com.adobeclassic.tests.pageobjects.TextComponentImpl;
import com.adobeclassic.tests.pages.TestPage;
import com.cognifide.qa.bb.aem.core.api.AemActions;
import com.cognifide.qa.bb.aem.core.component.actions.ConfigureComponentData;
import com.cognifide.qa.bb.aem.core.component.configuration.ResourceFileLocation;
import com.cognifide.qa.bb.aem.core.pages.sling.SlingDataXMLBuilder;
import com.cognifide.qa.bb.aem.core.pages.sling.SlingPageData;
import com.cognifide.qa.bb.api.actions.ActionException;
import com.cognifide.qa.bb.api.actions.ActionsController;
import com.cognifide.qa.bb.junit5.guice.Modules;
import com.cognifide.qa.bb.modules.BobcatRunModule;
import com.cognifide.qa.bb.page.BobcatPageFactory;
import com.google.inject.Inject;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Modules(BobcatRunModule.class)
@Epic("Hero V2 authoring and Publisher Tests")

public class HeroV2Test {

	@Inject
	private ActionsController controller;

	@Inject
	private BobcatPageFactory bobcatPageFactory;

	private final static String PAGE_TO_CREATE_TITLE = "HeroV2 page";
	private static final String TEST_PAGE_PATH = "/content/whitelabel/en_us/home/regression-node/herov2page";

	@BeforeEach
	public void loginAndCreateTestPage() throws ActionException {
		controller.execute(AemActions.LOG_IN);
		controller.execute(AemActions.CREATE_PAGE_VIA_SLING,
				new SlingPageData(TEST_PAGE_PATH, SlingDataXMLBuilder.buildFromFile("configure/herov2/HeroV2.xml")));
	}

	@Test
	@Feature("Hero V2 Component Image Authoring Tests")
	public void configureHeroV2Component() throws ActionException {
		TestPage testPage = bobcatPageFactory.create("/editor.html" + TEST_PAGE_PATH + ".html", TestPage.class);
		testPage.setTitle(PAGE_TO_CREATE_TITLE);
		assertTrue(testPage.open().isDisplayed());
		controller.execute(AemActionsAdobeClassic.CONFIGURE_COMPONENT_ADOBECLASSIC, new ConfigureComponentData("container[4]",
				"Hero V2", 0, new ResourceFileLocation("configure/template/homepage/testdata/HeroV2Image.yaml")));

	}

	@Test
	@Feature("Hero V2 Component Video Authoring Tests")
	public void configureHeroV2ComponentVideo() throws ActionException {
		TestPage testPage = bobcatPageFactory.create("/editor.html" + TEST_PAGE_PATH + ".html", TestPage.class);
		testPage.setTitle(PAGE_TO_CREATE_TITLE);
		assertTrue(testPage.open().isDisplayed());
		controller.execute(AemActionsAdobeClassic.CONFIGURE_COMPONENT_ADOBECLASSIC, new ConfigureComponentData("container[4]",
				"Hero V2", 1, new ResourceFileLocation("configure/template/homepage/testdata/HeroV2Video.yaml")));

	}

//	@AfterEach
//	public void deleteTestPage() throws ActionException {
//		controller.execute(AemActions.DELETE_PAGE_VIA_SLING, new SlingPageData(TEST_PAGE_PATH));
//	}
}