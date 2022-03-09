@catalog
Feature: Catalog pages
  Catalog pages that need testing

  @Women
  Scenario: I can mouse over Women Header
    Given I am on the home page
    When I mouse of the "Women" header
    Then The "Women" dropdown appears

  Scenario: I can click on a header
    Given I am on the home page
    And I click on the "Women" header
    Then Then I go to the "Women" product page

  Scenario: I want to use the filter buttons
    Given I am on a category page
    And I click "size" size button
    Then the site filters by size

  Scenario: I want to add to basket
    Given I am on a category page
    And I Hover over a product
    And I click add to basket
    Then the product is added to the basket

  Scenario: I want to add to wishlist
    Given I am on a category page
    And I Hover over a product
    And I click add to wishlist
    Then the product is added to the wishlist

  Scenario: I want to add to compare products
    Given I am on a category page
    And I Hover over a product
    And I click add to compare
    Then the product is added to the compare page

  Scenario: I want to inspect a product
    Given I am on the category page
    And I Hover over a product
    And I click the quick view
    Then I am taken to the product page


