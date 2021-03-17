package com.adobeclassic.tests.pages;
//package unilever.regressiontest.login;
//
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.Test;
//
//import com.cognifide.qa.bb.aem.core.api.AemActions;
//import unilever.regressiontest.pages.TestPage;
//import com.cognifide.qa.bb.api.actions.ActionException;
//import com.cognifide.qa.bb.api.actions.ActionsController;
//import com.cognifide.qa.bb.junit5.guice.Modules;
//import com.cognifide.qa.bb.modules.BobcatRunModule;
//import com.cognifide.qa.bb.page.BobcatPageFactory;
//import com.google.inject.Inject;
//
//import io.qameta.allure.Description;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.Story;
//
//@Modules(BobcatRunModule.class)
//@Epic("AEM 6.5 Base Tests")
//@Feature("Login to AEM")
//public class AuthorizationTest {
//
//  @Inject
//  private ActionsController controller;
//
//  @Inject
//  private BobcatPageFactory bobcatPageFactory;
//
//  @Test
//  @Story("Login to AEM and open Test page")
//  @Description("Login to author instance and open test page")
//  public void loginTest() throws ActionException {
//    TestPage testpage = bobcatPageFactory.create("/content/whitelabel/en_us/home/spotlight.html", TestPage.class);
//    controller.execute(AemActions.LOG_IN);
//    assertTrue(testpage.open().isDisplayed());
//  }
//}
