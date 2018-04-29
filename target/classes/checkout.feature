Feature: Checkout
  As a logged user I want to be able to do a checkout so I can purchase items

  Background:
    Given I'm logged in the west marine home page

    Scenario: Purchase items
      When I type "boat shoes" in the search field
      And I click on the search button
      Then I should see results for 'boat shoes'
      And I select "P018758987"
      And I select size '6'
      #And I add the item to the Shopping cart
      #And I go the Shopping cart
      #And I press the checkout button
      #And I fill out the shipping address form
      #And I press the Save button
      #And I choose the delivery method
      #And I fill out the payment method form
      #And I press the save button
      #Then I Submit the order
