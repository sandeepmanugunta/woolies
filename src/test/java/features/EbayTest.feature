@ebay
  @reset

Feature: ebay


  Scenario Outline: I want to be able to add 2 items to the cart/trolley and go to checkout
    Given I am on ebay page
    And I search for required "<Product1>"
    When I select first product
    Then I click on Add to cart
    And I search for required "<Product2>"
    Then I select second product
    And I click on Add to cart
    Then I click on checkout

    Examples:
      | Product1    | Product2 |
      | casio watch | RayBan   |



