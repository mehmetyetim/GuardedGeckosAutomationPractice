Feature: Product pages


  @AddtoCart
  Scenario: Add to cart
    Given I am on a product page
    And I click add to basket
    Then the product is added to the basket

  Scenario: Add to cart a custom amount
    Given I am on a product page
    And I change the number of quantity
    And I click add to basket
    Then the correct number of product is added to the basket

  Scenario: I want to change the size
    Given I am on a product page
    And I click add to wishlist
    Then the product is added to the wishlist

    Scenario: I want to change the size
      Given I am on a product page
      And I click the size dropdown
      And I select a new size
      Then the new size is selected