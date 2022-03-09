package com.guardedgeckos.automationpractice.step_definitions;

import com.guardedgeckos.automationpractice.pages.SignInPage;
import com.guardedgeckos.automationpractice.pages.cart.myaccount.MyAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LogInStepDefs {
        private static WebDriver webDriver;
        private static SignInPage signInPage;
        private static MyAccountPage myAccountPage;

        @Before
        public void setup() {
               System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
               System.out.println("setup");
        }

        @Given("I am on the login page")
        public void iAmOnTheLoginPage() {
                webDriver = new ChromeDriver();
                signInPage = new SignInPage(webDriver);
                signInPage.clickSignInButton();
                webDriver.getCurrentUrl();
                webDriver.get("http://automationpractice.com/index.php");
        }

        @When("I enter my registered email")
        public void iEnterMyRegisteredEmail() {
                signInPage = new SignInPage(webDriver);
                signInPage.enterEmail("sajad.gulzar2022@hotmail.co.uk");
        }

        @And("I enter my correct password and click the 'login' button")
        public void iEnterMyCorrectPasswordAndClickLoginButton() {
                signInPage.enterPassword("Neil Weightman");
                signInPage.clickSignInButton();
        }


        @Then("I will go to the My Account page")
        public void iWillGoToTheMyAccountPage() {
                myAccountPage = new MyAccountPage(webDriver);
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", myAccountPage.getDefaultUrl());
        }


        @And("I should see my account information")
        public void iShouldSeeMyAccountInformation() {
               myAccountPage.clickOrderHistoryAndDetailsButton();
               myAccountPage.clickMyAddressesButton();
               myAccountPage.clickMyPersonalInformationButton();
               myAccountPage.clickMyCreditSlipsButton();
               myAccountPage.clickMyWishlistsButton();
               myAccountPage.getAccount();
        }

        @When("I insert an unregistered email")
        public void iInsertAnUnregisteredEmail() {
                signInPage = new SignInPage(webDriver);
                signInPage.enterEmail("sajaaad.gulzar2000@gmail.com");
        }

        @And("I insert a valid password and click the 'login' button")
        public void iInsertAValidPasswordAndClickLoginButton() {
                signInPage.enterPassword("Neil Nishant");
                signInPage.clickSignInButton();
        }

        @Then("I will stay in the Login Page")
        public void iWillStayInTheLoginPage() {
              Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", signInPage.getDefaultUrl());

        }

       /*

        @When("I insert a registered email")
        public void iInsertARegisteredEmail() {
                signInPage = new SignInPage(webDriver);
                signInPage.enterEmail("finalproject@test.com");
        }

        @And("I insert an invalid password and click the 'login' button")
        public void iInsertAnInvalidPasswordAndClickLoginButton() {
                signInPage.enterPassword("SpartaGlobal1");
                signInPage.clickSignInButton();
        }


        @Then("I will stay in the Login Page")
        public void iWillStayInTheLoginPage1() {
            Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", signInPage.getCurrentUrl());

        }

         */

        @When("I click on 'Forgot your password?")
        public void iClickOnForgotYourPassword() {

        }

        //High priority?
        @Then("I will be directed to another page to reset my password")
        public void iWillRedirectedToAAnotherPageToResetMyPassword() {
           Assertions.assertEquals("http://automationpractice.com/index.php?controller=password", signInPage.getDefaultUrl());

        }

        @When("I am on the login page and click on 'Create Account'")
        public void iAmOnTheLoginPageAndClickOnCreateAccount() {
                signInPage = new SignInPage(webDriver);
                signInPage.enterEmail("sajad.northlondon@hotmail.com");

        }

        @Then("I will be directed to another page to finish the account creation")
        public void iWillBeAbledirectedToAnotherPageToFinishTheAccountCreation() {
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation", signInPage.getDefaultUrl());

        }

        @After
        public static void tearDown() {
                if (webDriver != null) {
                        //    manager.quitDriver();
                        System.out.println("tearDown login");
                }
        }
}
