package com.guardedgeckos.automationpractice.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LogInStepDefs {
        private static WebDriver webDriver;

        @Before
        public void setup() {
            //    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                System.out.println("setup");
        }

        @Given("I am on the login page")
        public void iAmOnTheLoginPage() {
                webDriver = new ChromeDriver();
                //  loginPage = new LoginPage(webDriver);
                //loginPage.clickSignInButton();
                webDriver.get("http://automationpractice.com/index.php");
        }

        @When("I enter my registered email")
        public void iEnterMyRegisteredEmail() {
                //loginPage = new LoginPage(webDriver);
                //loginPage.enterUsername("sajad.gulzar2022@hotmail.co.uk");
        }

        @And("I enter my correct password and click the 'login' button")
        public void iEnterMyCorrectPasswordAndClickLoginButton() {
                //loginPage.enterPassword("Neil Weightman");
                //loginPage.clickLogInButton();
        }

        @Then("I will go to the My Account page")
        public void iWillGoToTheMyAccountPage() {
                //myAccountPage = new MyAccountPage(webdriver);
                //Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", myAccountPage.getCurrentURL());
        }

        @And("I should see my account information")
        public void iShouldSeeMyAccountInformation() {
                //myAccountPage.isInformationPresent();
        }

        @When("I insert an unregistered email")
        public void iInsertAnUnregisteredEmail() {
                //loginPage = new LoginPage(webDriver);
                //loginPage.enterUsername("sajaaad.gulzar2000@gmail.com");
        }

        @And("I insert a valid password and click the 'login' button")
        public void iInsertAValidPasswordAndClickLoginButton() {
                //loginPage.enterPassword("Neil Nishant");
                //loginPage.clickLogInButton();
        }

        @Then("I will stay in the Login Page")
        public void iWillStayInTheLoginPage() {
                //Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", loginPage.getCurrentURL());
        }

        @When("I insert a registered email")
        public void iInsertARegisteredEmail() {
                //loginPage = new LoginPage(webDriver);
                //loginPage.enterUsername("finalproject@test.com");
        }

        @And("I insert an invalid password and click the 'login' button")
        public void iInsertAnInvalidPasswordAndClickLoginButton() {
                //loginPage.enterPassword("SpartaGlobal1");
                //loginPage.clickLogInButton();
        }

        @Then("I will stay in the Login Page")
        public void iWillStayInTheLoginPage1() {
                //Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", loginPage.getCurrentURL());
        }

        @When("I click on 'Forgot your password?")
        public void iClickOnForgotYourPassword() {

        }

        @Then("I will be redirected to another page to reset my password")
        public void iWillBeRedirectedToAAnotherPageToResetMyPassword() {
                //Assertions.assertEquals("http://automationpractice.com/index.php?controller=password", loginPage.getCurrentURL());

        }

        @When("I am on the login page and click on 'Create Account'")
        public void iAmOnTheLoginPageAndClickOnCreateAccount() {

        }

        @Then("I will be redirected to another page to finish the account creation")
        public void iWillBeAbleRedirectedToAnotherPageToFinishTheAccountCreation() {
                //Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation", loginPage.getCurrentURL());
        }

        @After
        public static void tearDown() {
                if (webDriver != null) {
                        //    manager.quitDriver();
                        System.out.println("tearDown login");
                }
        }
}
