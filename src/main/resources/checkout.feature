Feature: Checkout
  As a logged user I want to be able to do a checkout so I can purchase items

  Background:
    Given I'm logged in the west marine home page

    Scenario: Purchase items
      When I type 'boat shoes' in the search field
      And I click on the search button
      #And I select the 'Sperry' one
      #And I choose the size
      #And I add the item to the cart
      #And I go the cart
      #When I click on the checkout button
