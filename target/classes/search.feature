Feature: As a user I want to search for a product so I can easily find it in the page

  Background:
    Given I am at "home" page


  Scenario: Performing a successful search
    When I type "boat shoes" in the search field
    And I click on the search button
    Then I should see results for "boat shoes"

  Scenario: Performing a no results search
    When I type "angel" in the search field
    And I click on the search button
    Then I should see zero results

