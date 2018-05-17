Feature: Guess checkout
  In order to purchase items as a no register user I must be able to perform checkout without registering

  Scenario: Guess checkout
    Given I'm in WestMarine Homepage
    And I type "water shoes" in the search field
    And I click on the search button
    Then I should see results for the item searched
    And I select "Women's Slip-On Aqua Socks"
    And I select size '8'
    And I add the item to the Shopping cart
    And I go the Shopping cart
    And I press the checkout button
    Then I should be at the "login/checkout" page
    When I press the Checkout as guest button
    And I fill out with correct information the shipping address form
    And I press the Save button
    And I choose the delivery method
    And I press the delivery Save button
    And I fill out the payment method form
    When I press the Payment Save button
    Then I Submit the order
