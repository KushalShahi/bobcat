package com.adobeclassic.qa.tests.templates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
@Epic("Home Page authoring tests")

public class HomePage {

	@Inject
	private ActionsController controller;

	@Inject
	private BobcatPageFactory bobcatPageFactory;

	private final static String PAGE_TO_CREATE_TITLE = "Home page | Unilevers";
	private static final String TEST_PAGE_PATH = "/content/whitelabel/en_ca/home/regression-test-pages/homepage";

	@BeforeEach
	public void loginAndCreateTestPage() throws ActionException {
		controller.execute(AemActions.LOG_IN);
		controller.execute(AemActions.CREATE_PAGE_VIA_SLING, new SlingPageData(TEST_PAGE_PATH,
				SlingDataXMLBuilder.buildFromFile("configure/template/homepage/HomePage.xml")));
	}

	@Test
	@Feature("Hero V2 Component Image Authoring Tests")
	public void configureHeroV2Component() throws ActionException {
		TestPage testPage = bobcatPageFactory.create("/editor.html" + TEST_PAGE_PATH + ".html", TestPage.class);
		testPage.setTitle(PAGE_TO_CREATE_TITLE);
		assertTrue(testPage.open().isDisplayed());
		controller.execute(AemActionsAdobeClassic.CONFIGURE_COMPONENT_ADOBECLASSIC,
				new ConfigureComponentData("container[4]", "Hero V2", 0,
						new ResourceFileLocation("configure/template/homepage/testdata/HeroV2Image.yaml")));

	}

	@Test
	@Feature("Section Navigation V2 Component Authoring Tests")
	public void configureSectionNavigationV2Component() throws ActionException {
		TestPage testPage = bobcatPageFactory.create("/editor.html" + TEST_PAGE_PATH + ".html", TestPage.class);
		testPage.setTitle(PAGE_TO_CREATE_TITLE);
		assertTrue(testPage.open().isDisplayed());
		controller.execute(AemActionsAdobeClassic.CONFIGURE_COMPONENT_ADOBECLASSIC,
				new ConfigureComponentData("container[4]", "Section Navigation V2", 1,
						new ResourceFileLocation("configure/template/homepage/testdata/SectionNavigationV2.yaml")));

	}

//	@AfterEach
//	public void deleteTestPage() throws ActionException {
//		controller.execute(AemActions.DELETE_PAGE_VIA_SLING, new SlingPageData(TEST_PAGE_PATH));
//	}
}