@phpflighttest
  @reset

Feature: PHPFlightTest

  Scenario: I want to be able to book flight
    Given I am on PHPTravel page
    When I select flight, details and search
    Then I click on flight book
    And I confirm the booking
