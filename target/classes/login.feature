Feature: As a registered user I want to be able to login in the West Marine page, so I can have a custom experience
  Background:
    Given I'm in WestMarine Homepage to login
    And I click on the Sign in button in the top bar
    Then I should see the login form

  @web
  Scenario: Successful login

    And I fill out the login form with correct information
    When I click on the Sign in button in the login form
    Then I'm succesfully logged in
    And I log out

  Scenario: Unsuccessful login

    And I fill out the login form with wrong information
    When I click on the Sign in button in the login form
    Then I should see an error message
