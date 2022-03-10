package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.MyAccountPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.OrderHistoryPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.OrderSlipPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class OrderSlipPageTest {
    private static WebDriver webDriver = DriverFactory.get();
    static MyAccountPage myAccountPage;
    static OrderSlipPage orderSlipPage;
    static SignInPage signInPage;

    @BeforeAll
    public static void setUp(){
        webDriver = DriverFactory.get();
        signInPage = new SignInPage(webDriver);
        signInPage.enterEmail("vzelohgcpdzokhclvd@bvhrk.com");
        signInPage.enterPassword("password");
        signInPage.clickSignInButton();
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyCreditSlipsButton();
    }

    @Test
    @DisplayName("alert shows if no credit slips")
    void alertShowsIfNoCreditSlips(){
        orderSlipPage = new OrderSlipPage(webDriver);
        Assertions.assertEquals("You have not received any credit slips.",orderSlipPage.getAlertText());
    }

    @Test
    @DisplayName("click back to your account go to my account page")
    void checkBackToYourAccountGoToMyAccountPage(){
        orderSlipPage = new OrderSlipPage(webDriver);
        orderSlipPage.clickBackToYourAccountButton();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("click Home go to homepage")
    void checkHomeGoToHomePage(){
        orderSlipPage = new OrderSlipPage(webDriver);
        orderSlipPage.clickHomeButton();
        Assertions.assertEquals("http://automationpractice.com/index.php", webDriver.getCurrentUrl());
    }


    @AfterAll
    static void close(){
        webDriver.quit();
    }
}
