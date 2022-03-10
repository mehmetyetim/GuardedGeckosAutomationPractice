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
      When I make a change to the basket
      Then the total price should change accordingly

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

    Scenario: As a Customer I should be able to pay by bank wire so that
      I can purchase my products
      Given I am on the payment method page
      When I click on the pay by bank wire button
      Then I should be on the Order summary page

    Scenario: As a Customer I should be able to pay by check so that
      I can purchase my products
      Given I am on the payment method page
      When I click on the pay by check button
      Then I should be on the Order summary page

    Scenario: As a Customer I should be able to choose a delivery address
      during the checkout process so that I can get my order delivered
      to the correct address
      Given I am on the address page
      When I click on the choose a delivery address drop down list and select a different delivery address
      Then the delivery address should be changed to the delivery address that I selected

    Scenario: As a Customer I should be able to add an address during the
      checkout process
      Given I am on the address page
      And I click on the add a new address button
      When I fill out the form and click save
      Then I should be able to select the newly added address when I choose a delivery address

    Scenario: As a Customer I should be able to have a different address
      for delivery address and billing address
      Given I am on the address page and I uncheck the checkbox for use the same delivery address as the billing address
      When I choose a different delivery address to the billing address
      Then the two addresses should be different

    Scenario: As a Customer I should be able to confirm my order after
      seeing order summary with my chosen payment option
      Given I am on the Order summary page
      When I click on confirm my order
      Then I should be taken to the order confirmation page