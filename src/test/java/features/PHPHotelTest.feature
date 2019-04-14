@phphoteltest
  @reset

Feature: PHPHotelTest

  Scenario: I want to be able to book Hotel
    Given I am on PHPTravel page
    When I search for hotel
    Then I select checkin, checkout, PAX and click on search
    And I confirm the booking
