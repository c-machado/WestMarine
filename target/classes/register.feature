Feature: Register a user in West Marine Site
  Scenario: Successful register
    Given I'm in WestMarine Homepage
    And I click to sign in
    And I have to choose create option
    And I fill out the form with correct information
    When I click on the Register button
    Then I'm succesfully registered