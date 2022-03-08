@account

  Feature: as a signed in user i will be able to use the My Account functions

    Background: valid user signed in
      Given i am on the account page

        Scenario: As a user I want to be able to see my order history and details
          When I click the Order History and Details button
          Then I should be taken to the Order History and Details page

        Scenario: As a user I want to be able to see my credit slips
          When I click the Credit Slips button
          Then I should be taken to the Credit Slips page

        Scenario: As a user I want to be able to see my saved addresses
          When I click the My Addresses button
          Then I should be taken to the My Addresses page

        Scenario: As a user I want to be able to see my personal information
          When I click the My Personal Information button
          Then I should be taken to the personal information page

        Scenario: As a user I want to be able to see my wish lists
          When I click the My Wishlists button
          Then I should be taken to the Wishlists page

      Given I am on the WishLists page
          Scenario: As a user I want to be able to add a new Wishlist
            When I given the Wishlist a name
            And i press save
            Then I should get a new wishlist

          Scenario: As a user I want to be able to remove a Wishlist
            When I press the "x" in the delete column of the wishlist
            And Press on on the conformation pop up
            Then the wishlist should be deleted

      Given I am on the Addresses page

            Scenario: As a user I want to be able to update my addresses
              When I press the update button
              And enter the new details and press save
              Then it should change the address

            Scenario: As a user I want to be able to add new addresses
              When I press the add new address button, enter the details
              And press save
              Then teh new address should be added

       Given I am on the personal Information page
              Scenario: As a user I want to be able to change my personal information
                When i edit my details
                And enter my password correctly and press save
                Then My details should be changed





