package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.*;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderHistoryPageTest {
    private static WebDriver webDriver = webDriver = DriverFactory.get();
    static MyAccountPage myAccountPage;
    static OrderHistoryPage orderHistoryPage;
    static SignInPage signInPage;

    @BeforeAll
    public static void setUp(){
        webDriver = DriverFactory.get();
        signInPage = new SignInPage(webDriver);
        signInPage.enterEmail("vzelohgcpdzokhclvd@bvhrk.com");
        signInPage.enterPassword("password");
        signInPage.clickSignInButton();
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickOrderHistoryAndDetailsButton();
    }


    @Test
    @DisplayName("click order reference & shows correct order")
    void clickOrderReferenceShowsCorrectOrder()
    {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertThat(orderHistoryPage.getOrderReferenceTextInTableBelow(), containsString(orderHistoryPage.getOrderReferenceText(1)));
    }

    @Test
    @DisplayName("click order reference & shows correct date")
    void clickOrderReferenceShowsCorrectDate()
    {
        orderHistoryPage = new OrderHistoryPage(webDriver);
        orderHistoryPage.clickOrderReference(1);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertThat(orderHistoryPage.getOrderReferenceTextInTableBelow(), containsString(orderHistoryPage.getOrderDate(1)));
    }

    @AfterAll
    static void close(){
        webDriver.quit();
    }



}
