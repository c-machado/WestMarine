Feature: As a registered user I want to be able to login in the West Marine page, so I can have a custom experience

  Scenario: Successful login

    Given I'm in WestMarine Homepage to login
    And I click on the Sign in button in the top bar
    Then I should see the login form
    And I fill out the form with correct information in login form
    When I click on the Sign in button in the login form
    Then I'm succesfully logged in