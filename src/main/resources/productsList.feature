Feature: As a user I want to see the products listed in the page so I can easily browse among them

  Scenario: Clicking on the cards
    Given I am at "men-s-shoes" page
    When I click one of the products
    Then I should be at the product page

  # These are possible scenarios to implement for this feature
  # Scenario: paginator
  # Scenario: select
  # Scenario: filter

