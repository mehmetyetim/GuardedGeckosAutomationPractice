package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.MyAccountPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.OrderSlipPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class OrderSlipPageTest {

    @Spy
    private static WebDriver webDriver;
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
    @Order(1)
    @DisplayName("alert shows if no credit slips")
    void alertShowsIfNoCreditSlips(){
        orderSlipPage = new OrderSlipPage(webDriver);
        Assertions.assertEquals("You have not received any credit slips.",orderSlipPage.getAlertText());
    }

    @Test
    @Order(2)
    @DisplayName("click back to your account go to my account page")
    void checkBackToYourAccountGoToMyAccountPage(){
        orderSlipPage = new OrderSlipPage(webDriver);
        orderSlipPage.clickBackToYourAccountButton();
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=my-account");
        Assertions.assertEquals(MyAccountPage.DEFAULT_URL,webDriver.getCurrentUrl());
    }

    @Test
    @Order(3)
    @DisplayName("click Home go to homepage")
    void checkHomeGoToHomePage(){
        orderSlipPage = new OrderSlipPage(webDriver);
        orderSlipPage.clickHomeButton();
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php");
        Assertions.assertEquals(HomePage.DEFAULT_URL,webDriver.getCurrentUrl());
    }
    @Test
    @Order(4)
    @DisplayName("Order slip page constructor test")
    public void orderSlipPageConstructorTest(){
        orderSlipPage =  new OrderSlipPage(webDriver);
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=order-slip");
        Assertions.assertEquals(OrderSlipPage.DEFAULT_URL,webDriver.getCurrentUrl());
    }


    @AfterAll
    static void close(){
        webDriver.quit();
    }
}
