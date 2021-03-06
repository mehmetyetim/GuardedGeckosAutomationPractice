@signin
Feature: As a registered user with valid email and password I will be able to login to the website

  Background: Setting up the Browser
    Given I am on the login page

  Scenario: Getting to the My Account page from the login page
    When I enter my registered email
    And I enter my correct password and click the 'login' button
    Then I will go to the My Account page


  Scenario: Staying in the Login Page as result of unregistered email address
    When I insert an unregistered email
    And I insert a valid password and click the login button
    Then I will stay in the Login webPage

  Scenario: Staying in the Login Page as result of invalid password
    When I insert a invalid password
    And I insert a registered email and click the login button
    Then I will stay in the Login webPage


  Scenario: Creating a new password in case of a forgotten one
    When I click on 'Forgot your password?
    Then I will be directed to another page to reset my password

    ## http://automationpractice.com/index.php?controller=password

  Scenario: Creating a new account from the login page
    When I am on the login page and I click on 'Create Account'
    Then I will be directed to another page to finish the account creation

     ## http://automationpractice.com/index.php?controller=authentication#account-creation
    