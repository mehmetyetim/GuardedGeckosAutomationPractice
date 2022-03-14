Feature: As a user I want to be able to navigate from the homepage so I can access other parts of the website
  @homepage
  Scenario Outline: As a user I should be able to click the banner or images sand move to the products on sale
    When I click <image>
    Then I am on a page of products
    Examples:
    |image|
    |banner|
    |3 days sale|
    |online only summer|
    |top trends        |
    |mens coats and jackets|
    |womens coats and jackets|
    |sunglasses and eye wear |
    |savvy trends handbags   |

  @navigation
  Scenario Outline: As a user I should be able to click the footer information and go to the correct pages
    When I click on footer <footer link>
    Then I am on <footer link> page
    Examples:
    |footer link|
    |women|
    |specials|
    |new products|
    |best sellers|
    |our stores|
    |contact us|
    |terms and conditions|
    |about us|
    |sitemap|
    |my orders|
    |my account|
    |my credit slips|
    |my addresses|
    |my personal info|
    |sign out|
    |facebook|
    |twitter|
    |youtube|
    |google plus|

  @homepage
  Scenario: As a user I should be able to click contact us to get access to the contact page
    When I click contact us
    Then I am on contact us page

  @homepage
  Scenario: As a user I want to be able to select checkout once I have finished shopping
    Given There is a product in the cart
    When I hover over the cart and click checkout
    Then I am on the summary page

  @homepage
  Scenario: As a user I want to be able to click quick view on a product and a window pop up with product details
    When I mouse over a product and click quick view
    Then The quick view window pops up








