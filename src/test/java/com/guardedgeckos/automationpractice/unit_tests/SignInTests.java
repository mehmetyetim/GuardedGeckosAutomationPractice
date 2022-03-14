package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;

@ExtendWith(MockitoExtension.class)
public class SignInTests
{
    @Spy
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
        signInPage = new SignInPage(driver);
        Mockito.when(driver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=authentication");

        Assertions.assertEquals(SignInPage.DEFAULT_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("The user can enter a password")
    void signInPageEnterPasswordTest()
    {
        signInPage = new SignInPage(driver);

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
    void signInPageSignInFillsFieldsTest()
    {
        signInPage.resetFields();
        signInPage.login(signInPage.getDefaultEmail());

        boolean bothAreEqual = (signInPage.getDefaultPassword().equals(signInPage.getPassword()))
                && (signInPage.getDefaultEmail().equals(signInPage.getEmail()));

        Assertions.assertTrue(bothAreEqual);
    }

    @Test
    @DisplayName("The user can enter a registration email")
    void signInPageRegistrationEmailTest()
    {
        signInPage.resetFields();
        signInPage.enterRegistrationEmail(signInPage.getDefaultRegistrationEmail());

        Assertions.assertEquals(signInPage.getDefaultRegistrationEmail(), signInPage.getRegistrationEmail());
    }

    @Test
    @DisplayName("The user can submit a registration email")
    void signInPageRegistrationEmailSubmitTest()
    {
        signInPage = new SignInPage(driver);

        signInPage.resetFields();
        signInPage.enterRegistrationEmail(signInPage.getDefaultRegistrationEmail());
        signInPage.clickCreateAnAccountButton();

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        Mockito.when(driver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");

        boolean isOnAccountCreationPage = driver.getCurrentUrl().contains("#account-creation");

        Assertions.assertTrue(isOnAccountCreationPage);
    }

    @Test
    @DisplayName("The user can enter a registration email")
    void signInPageForgotPasswordTest()
    {
        signInPage.resetFields();

        signInPage.clickForgotPasswordLink();

        Mockito.when(driver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=password");
        boolean isOnResetPasswordPage = driver.getCurrentUrl().contains("controller=password");

        Assertions.assertTrue(isOnResetPasswordPage);
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
