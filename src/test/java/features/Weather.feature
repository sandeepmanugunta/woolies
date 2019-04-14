@weather
  @reset

Feature: Weather Test


  Scenario: A happy holidaymaker
    Given I like to holiday in Sydney
    When I only like to holiday on Thursdays
    Then I look up the weather forecast
    And I receive the weather forecast