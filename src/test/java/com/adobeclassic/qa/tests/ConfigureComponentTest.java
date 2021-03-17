package com.adobeclassic.qa.tests;
//package unilever.regressiontest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import unilever.regressiontest.pageobjects.RichTextV2Component;
//import unilever.regressiontest.pageobjects.TextComponentImpl;
//import unilever.regressiontest.pages.TestPage;
//import com.cognifide.qa.bb.aem.core.api.AemActions;
//import com.cognifide.qa.bb.aem.core.component.actions.ConfigureComponentData;
//import com.cognifide.qa.bb.aem.core.component.configuration.ResourceFileLocation;
//import com.cognifide.qa.bb.aem.core.modules.Aem65FullModule;
//import com.cognifide.qa.bb.aem.core.pages.sling.SlingDataXMLBuilder;
//import com.cognifide.qa.bb.aem.core.pages.sling.SlingPageData;
//import com.cognifide.qa.bb.api.actions.ActionException;
//import com.cognifide.qa.bb.api.actions.ActionsController;
//import com.cognifide.qa.bb.junit5.guice.Modules;
//import com.cognifide.qa.bb.modules.BobcatRunModule;
//import com.cognifide.qa.bb.page.BobcatPageFactory;
//import com.google.inject.Inject;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//@Modules(BobcatRunModule.class)
//@Epic("AEM 6.5 Base Tests")
//@Feature("Rich Text Component Authoring Tests")
//
//public class ConfigureComponentTest {
//
//	@Inject
//	private ActionsController controller;
//
//	@Inject
//	private BobcatPageFactory bobcatPageFactory;
//
//	private final static String PAGE_TO_CREATE_TITLE = "Test page | Whitelabel";
//	private static final String TEST_PAGE_PATH = "/content/whitelabel/en_us/home/spotlight/test";
//	
//	
//	@BeforeEach
//	public void loginAndCreateTestPage() throws ActionException {
//		controller.execute(AemActions.LOG_IN);
//		controller.execute(AemActions.CREATE_PAGE_VIA_SLING, new SlingPageData(TEST_PAGE_PATH,
//				SlingDataXMLBuilder.buildFromFile("pageTest.xml")));
//
//	}
//
//	@Test
//	public void configureTextComponentTest() throws ActionException {
//		TestPage testPage = bobcatPageFactory.create("/editor.html" + TEST_PAGE_PATH + ".html", TestPage.class);
//		testPage.setTitle(PAGE_TO_CREATE_TITLE);
//		assertTrue(testPage.open().isDisplayed());
//		controller.execute(AemActions.CONFIGURE_COMPONENT, new ConfigureComponentData("container[4]",
//				"Rich Text V2", 0, new ResourceFileLocation("RichTextV2component.yaml")));
//		TextComponentImpl content = (TextComponentImpl) testPage.getContent(RichTextV2Component.class, 0);
//
//		assertThat(content.getInnerHTML().trim().replaceAll("\\r|\\n", "")).matches("test activity");
//	}
//
////	@AfterEach
////	public void deleteTestPage() throws ActionException {
////		controller.execute(AemActions.DELETE_PAGE_VIA_SLING, new SlingPageData(TEST_PAGE_PATH));
////	}
//}