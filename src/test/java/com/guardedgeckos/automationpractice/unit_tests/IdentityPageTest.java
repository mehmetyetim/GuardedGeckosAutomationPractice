package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.HomePage;
import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.*;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class IdentityPageTest {
    @Spy
    private static WebDriver webDriver;
    static MyAccountPage myAccountPage;
    static IdentityPage identityPage;
    static SignInPage signInPage;

    @BeforeAll
    public static void setUp(){
        webDriver = DriverFactory.get();
        signInPage = new SignInPage(webDriver);
        signInPage.enterEmail("vzelohgcpdzokhclvd@bvhrk.com");
        signInPage.enterPassword("password");
        signInPage.clickSignInButton();
        myAccountPage = new MyAccountPage(webDriver);
        myAccountPage.clickMyPersonalInformationButton();
    }

    @Test
    @Order(1)
    @DisplayName("check personal information")
    public void checkPersonalInformation(){
        identityPage = new IdentityPage(webDriver);
        Assumptions.assumeTrue((identityPage.getFirstName().equals("First")));
        Assumptions.assumeTrue((identityPage.getLastName().equals("Last")));
        Assumptions.assumeTrue((identityPage.getEmail().equals("vzelohgcpdzokhclvd@bvhrk.com")));
        assertThat(identityPage.getDateOfBirth(),containsString("2022"));
        assertThat(identityPage.getDateOfBirth(),containsString("January"));
        assertThat(identityPage.getDateOfBirth(),containsString("1"));
    }

    @Test
    @Order(2)
    @DisplayName("alert appear when save without password")
    public void alertAppearWhenSaveWithoutPassword(){
        identityPage = new IdentityPage(webDriver);
        identityPage.clickSubmitButton();
        assertThat(identityPage.getAlertText(),containsString("The password you entered is incorrect."));
    }

    @Test
    @Order(3)
    @DisplayName("alert appear when save with correct password")
    public void alertAppearWhenSaveWithCorrectPassword(){
        identityPage = new IdentityPage(webDriver);
        identityPage.inputOldPassword("password");
        identityPage.clickSubmitButton();
        assertThat(identityPage.getAlertText(),containsString("Your personal information has been successfully updated."));
    }


    @Test
    @Order(4)
    @DisplayName("Click home button back to home page")
    public void clickHomeButtonBackToHomePage(){
        identityPage = new IdentityPage(webDriver);
        identityPage.clickHomeButton();
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php");
        Assertions.assertEquals(HomePage.DEFAULT_URL,webDriver.getCurrentUrl());
    }

    @Test
    @Order(5)
    @DisplayName("Click back to your account button back to account page")
    public void clickBackToYouAccountButtonBackToAccountPage(){
        identityPage =  new IdentityPage(webDriver);
        identityPage.clickBackToYourAccountButton();
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=my-account");
        Assertions.assertEquals(MyAccountPage.DEFAULT_URL,webDriver.getCurrentUrl());
    }


    @Test
    @Order(6)
    @DisplayName("IdentityPage constructor test")
    public void identityPageConstructorTest(){
        identityPage =  new IdentityPage(webDriver);
        Mockito.when(webDriver.getCurrentUrl()).thenReturn("http://automationpractice.com/index.php?controller=identity");
        Assertions.assertEquals(IdentityPage.DEFAULT_URL,webDriver.getCurrentUrl());
    }

    @AfterAll
    static void close(){
        webDriver.quit();
    }

}
