package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class SignInTests
{
    static WebDriver driver;
    static SignInPage signInPage;

    //region Before All
    @BeforeAll
    static void setupAll(TestInfo testInfo)
    {
        driver = DriverFactory.get();
        signInPage = new SignInPage(driver);
    }
    //endregion

    //region Tests
    @Test
    @DisplayName("Check that the page defaults to the base url")
    void signInPageConstructorTest()
    {
        Assertions.assertEquals(signInPage.getDefaultUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("The user can enter a password")
    void signInPageEnterPasswordTest()
    {
        signInPage.enterPassword(signInPage.getDefaultPassword());

        Assertions.assertEquals(signInPage.getDefaultPassword(), signInPage.getPassword());
    }

    @Test
    @DisplayName("The user can enter an email address")
    void signInPageEnterEmailTest()
    {
        signInPage.enterEmail(signInPage.getDefaultEmail());

        Assertions.assertEquals(signInPage.getDefaultEmail(), signInPage.getEmail());
    }

    @Test
    @DisplayName("The user can sign in")
    void signInPageSignInTest()
    {
        signInPage.resetFields();
        signInPage.login(signInPage.getDefaultEmail());

        boolean bothAreEqual = (signInPage.getDefaultPassword().equals(signInPage.getPassword()))
                && (signInPage.getDefaultEmail().equals(signInPage.getEmail()));

        Assertions.assertTrue(bothAreEqual);
    }
    //endregion

    //region After All
    @AfterAll
    static void tearDownAll()
    {
        driver.close();
        driver.quit();
    }
    //endregion
}
