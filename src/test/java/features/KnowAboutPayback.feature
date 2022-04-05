Feature:  Know About Payback
  Background:
    Given The WebDriver is initialized
    And Users can navigate to payback using "https://www.payback.in/" link
    And The user is logged in with valid credentials

    Scenario: Verify if KnowYourPayback button is working accordingly
      When Hover to the 'Explore' tab and click on 'KnowYourPayback'
      Then Page with link "https://www.payback.in/know-about-payback" open

    Scenario: 