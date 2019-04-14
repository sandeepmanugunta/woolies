@phptourtest
  @reset

Feature: PHPTourTest

  Scenario: I want to be able to book Tour
    Given I am on PHPTravel page
    When I select checkin, guest and search
    Then I click on book
    And I confirm the booking
