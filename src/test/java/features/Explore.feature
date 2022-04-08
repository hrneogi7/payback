Feature: Explore tab on nav bar
  Background:
    Given Users can navigate to payback using "https://www.payback.in/" link

  Scenario Outline: All the buttons in the Explore dropdown list is taking us to respective pages
    Given Users can hover over to "Explore" tab
    When click on "<button>" from dropdown list
    Then Respective <WebPage> is fetched

    Examples:
      | button           | WebPage                                                               |
      | InstantVouchers  | "https://www.gyftr.com/payback?token=TEMPXYZ786&utm_source=undefined" |
      | KnowAboutPayback | "https://www.payback.in/know-about-payback"                           |
      | Offers           | "https://www.payback.in/offers"                                       |
      | OurPartners      | "https://www.payback.in/our-partners"                                 |
      | PaybackPlus      | "https://www.payback.in/payback-plus"                                 |



