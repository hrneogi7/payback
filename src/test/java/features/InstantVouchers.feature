Feature: Instant Vouchers
  Background:
    Given The WebDriver is initialized
    And Users can navigate to payback using "https://www.payback.in/" link
    And The user is logged in with valid credentials

    Scenario: Verify if the Instant Voucher button is working
      When Hover to the 'Explore' tab and click on 'InstantVouchers'
      Then Website with link "https://www.gyftr.com/payback?token=TEMPXYZ786&utm_source=undefined" should open