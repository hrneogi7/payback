Feature: Our Partners Web page

  Background:
    Given User is logged in using "8910794026" and "3874"
    And Then Hover over to Explore tab and clicked on Our partner
  @lowpriority
  Scenario: User will be taken to partner brand page on clicking on Details
    When User clicked on Details button of brand "American Express"
    Then It fetch the partner brand page "https://www.payback.in/partner-brands/american-express"
  @lowpriority
  Scenario: User will be taken to partner brand page on clicking on Details
    When User clicked on Details button of brand "Thomas Cook"
    Then It fetch the partner brand page "https://www.payback.in/partner-brands/thomas-cook"
  @lowpriority
  Scenario: User will be taken to partner brand page on clicking on Details
    When User clicked on Details button of brand "Book my show"
    Then It fetch the partner brand page "https://www.payback.in/partner-brands/bookmyshow"

#  Scenario: User is able to land in our partner website on clicking Shop under EARN POINTS section
#    When User clicked on Shop button under "Amazon"
#    And Clicked on Proceed after that in the intermediate landing page
#    Then User is taken to "Amazon" Website
#
#  Scenario: User is able to land in our partner website on clicking Shop under EARN POINTS section
#    When User clicked on Shop button under "Dyson"
#    And Clicked on Proceed after that in the intermediate landing page
#    Then User is taken to "Dyson" Website