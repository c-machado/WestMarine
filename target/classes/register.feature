@test
Feature: As a user I want to register in the WestMarine page so I can manage my billing data

  Scenario: Successful register
    Given I'm in WestMarine Homepage
    When I click to sign in
    And I have to choose create option
    And I fill out the form with correct information
    And I click on the Register button
    Then I'm succesfully registered