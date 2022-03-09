package com.guardedgeckos.automationpractice.unit_tests;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.*;
import com.guardedgeckos.automationpractice.utilities.DriverFactory;
import io.cucumber.java.bs.I;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class IdentityPageTest {

    private static WebDriver webDriver = DriverFactory.get();
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
    @DisplayName("alert appear when save without password")
    public void alertAppearWhenSaveWithoutPassword(){
        identityPage = new IdentityPage(webDriver);
        identityPage.clickSubmitButton();
        assertThat(identityPage.getAlertText(),containsString("The password you entered is incorrect."));
    }

    @Test
    @DisplayName("alert appear when save with correct password")
    public void alertAppearWhenSaveWithCorrectPassword(){
        identityPage = new IdentityPage(webDriver);
        identityPage.inputOldPassword("password");
        identityPage.clickSubmitButton();
        assertThat(identityPage.getAlertText(),containsString("Your personal information has been successfully updated."));
    }

    @AfterAll
    static void close(){
      //  webDriver.quit();
    }

}
