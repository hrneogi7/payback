Feature:  Payback Plus Page
  Background:
    Given Users can navigate to payback using "https://www.payback.in/payback-plus" link
  @mediumpriority
  Scenario: All the links in the section 'Extra value upto Rs. 6,500 on shopping & vouchers' are working properly
    When Click on Buy button of the brand "The man company"
    Then the respective "The Man Company" webpage should open in new tab
  @mediumpriority
  Scenario: All the links in the section 'Extra value upto Rs. 6,500 on shopping & vouchers' are working properly
    When Click on Buy button of the brand "1mg"
    Then the respective "1mg" webpage should open in new tab

  @highpriority
  Scenario: Upgrade with points page is successfully opened
    When User clicked on Upgrade with Points button
    Then Fetch the page with link "https://www.payback.in/paybackplus"
  @highpriority
  Scenario: Upgrade with points + pay page is successfully opened
    When When user clicked on Upgrade with Points + pay button
    Then Fetch the page with link "https://rewards.payback.in/pbplus.aspx?utm_source=web"