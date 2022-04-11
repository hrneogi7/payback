Feature: Explore tab on nav bar
  Background:
    Given Users can navigate to payback using "https://www.payback.in/" link
  @mediumpriority
  Scenario Outline: All the buttons in the Explore dropdown list is taking us to respective pages
    Given Users can hover over to "Explore" tab
    When click on button from Test Sheet "TestData1" and row <row_number>
    Then Respective Webpage is fetched from Test Sheet "TestData1" and row <row_number>

    Examples:
      | row_number          |
      | 1                   |
      | 2                   |
      | 3                   |
      | 4                   |
      | 5                   |



