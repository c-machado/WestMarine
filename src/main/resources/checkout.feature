Feature: Checkout
  As a logged user I want to be able to do a checkout so I can purchase items

  Background:
    Given I'm in WestMarine Homepage to login
    And I click on the Sign in button in the top bar
    Then I should see the login form
    And I fill out the form with correct information in login form
    When I click on the Sign in button in the login form
    Then I'm succesfully logged in

    Scenario: Purchase items
      Given I search for 'boat shoes' items
      And I click on the search button
      And I select the 'Sperry' one
      And I choose the size
      And I add the item to the cart
      And I go the cart
      When I click on the checkout button
