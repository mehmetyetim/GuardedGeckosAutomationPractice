@Cart
Feature: As a User I want to be able buy the products that I want.

  Background:
    Given I am on the shopping cart summary page
    And I have shopping in the basket

    Scenario: As a Customer I should be able to increase the quantity of a
      product from the shopping cart
      When I click on the plus button
      Then The quantity should increase

    Scenario: As a customer if I have a empty basket I should see that
      my shopping cart is empty
      Given my shopping cart is empty on the shopping cart summary page
      Then display your shopping cart is empty
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

    Scenario: As a Customer I should be able to update my billing address
      during the checkout process
      Given I am on the address stage of the checkout
      When I click on the update button for billing address
      And I update the form and press save
      Then my billing address should be updated

    Scenario: As a Customer I should be able to choose my shipping method
      during the checkout process
      Given I am on the shipping page
      When I click on the shipping method I want
      Then it should be selected

    Scenario: As a Customer I should be able to agree to the terms of
      service so that I can continue with the checkout process
      Given I am on the shipping page
      And I click on the  I agree tickbox
      When I click on the proceed to checkout button
      Then I should be on the payment method page

    Scenario: As a Customer I should be kept on the shipping page when I
      click proceed to checkout without agreeing to the terms of service
      Given I am on the shipping page
      And the terms of service checkbox is unticked
      When I click on proceed to checkout
      Then I should see an error message

      