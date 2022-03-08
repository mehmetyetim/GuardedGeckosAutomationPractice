@Cart
Feature: As a User I want to be able buy the products that I want.

  Background:
    Given I am on the shopping cart summary page
    And I have shopping in the basket

    Scenario: As a Customer I should be able to increase the quantity of a
      product from the shopping cart
      When I click on the plus button
      Then The quantity should increase

    Scenario: As a Customer I should be able to decrease the quantity of a
      product from the shopping cart
      When I click the minus button
      Then the quantity should decrease

    Scenario: As a Customer I should be able to remove a product from the
      shopping cart
      When I click on the remove product button
      Then the product should be removed from the basket

    Scenario: As a Customer I should be able to see the total price
      for the products in my basket


    Scenario: As a Customer I should be able to update my delivery
      address during the checkout process so that my product
      gets delivered to the correct place
      Given I am on the address stage of the checkout
      When I click on the update button for delivery address
      And I update the form and press save
      Then my delivery address should be updated
