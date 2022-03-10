@Cart
Feature: As a User I want to be able buy the products that I want.

  Background:

    Given I have shopping in the basket
    And I am on the shopping cart summary page
    And I am logged in

    Scenario: As a customer if I have a empty basket I should see that
      my shopping cart is empty
      Given my shopping cart is empty on the shopping cart summary page
      Then display your shopping cart is empty

    Scenario: As a Customer I should be able to remove a product from the
      shopping cart
      When I click on the remove product button
      Then the product should be removed from the basket

    Scenario: As a Customer I should be able to agree to the terms of
      service so that I can continue with the checkout process
      Given I am on the shipping page
      And I click on the  I agree tickbox
      When I click on the proceed to checkout button
      Then I should be on the payment method page
#    TODO: implement this scenario H
#    Scenario: As a Customer I should be kept on the shipping page when I
#      click proceed to checkout without agreeing to the terms of service
#      Given I am on the shipping page
#      And the terms of service checkbox is unticked
#      When I click on proceed to checkout
#      Then I should see an error message

    Scenario: As a Customer I should be able to pay by bank wire so that
      I can purchase my products
      Given I am on the payment method page
      When I click on the pay by bank wire button
      Then I should be on the Order summary page

    Scenario: As a Customer I should be able to pay by check so that
      I can purchase my products
      Given I am on the payment method page
      When I click on the pay by check button
      Then I should be on the cheque Order summary page


    Scenario: As a Customer I should be able to confirm my order after
      seeing order summary with my chosen payment option
      Given I am on the Order summary page
      When I click on confirm my order
      Then I should be taken to the order confirmation page