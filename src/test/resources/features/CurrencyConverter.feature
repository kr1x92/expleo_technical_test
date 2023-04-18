Feature: Currency Conversion
  Scenario Outline: Verify multiple conversion rates
    Given I am on the Currency Converter page and accept cookies
    When I enter "<amount>" in the amount field
    And I select "<currencyFrom>" from the 'From' currency dropdown
    And I select "<currencyTo>" from the 'To' currency dropdown
    And I click on the Convert button
    Then I should see the converted amount in the result

    Examples:
  | amount | currencyFrom      | currencyTo       |
  | 100    | Euro              | British Pound    |
  | 100    | US Dollar         | Euro             |
  | 200    | Canadian Dollar   | Japanese Yen     |
  | 200    | Australian Dollar | US Dollar        |
  | 200    | Japanese Yen      | Australian Dollar|