@smoke
Feature: As a registered user I want to be able to login in the West Marine page, so I can have a custom experience

  Background:
    Given The login form is displayed in the WestMarine Homepage

  Scenario Outline:  Successful login
    When I fill out the login form with "<username>" and "<password>" information
    And I click on the Sign in button in the login form
    Then I'm succesfully logged in
    Examples:
      | username            | password |
      | dcmachado@gmail.com | E123?asd |

  Scenario: Unsuccessful login
    When I fill out the login form with wrong information
    And I click on the Sign in button in the login form
    Then I should see an error message

