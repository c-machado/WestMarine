Feature: As a user I want to register in the WestMarine page so I can manage my billing data

  Scenario: Successful register
    Given I am at "home" page
    When I click to sign in
    And I choose the create option
    And I fill out the register form with the correct information
    And I click on the Register button
    Then I should be registered