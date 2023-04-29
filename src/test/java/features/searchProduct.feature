Feature: Search and Place the order for Products

  @OffersPage
  Scenario Outline: Search Experience for product search in both Home and Offers page

    Given User is on GreenKart Landing page
    When User searches with shortname <Name> and extracts actual name of product
    Then User searches for <Name> shortname in Offers page
    And validates product name in Offers page matches with Landing page
    Examples:
      | Name |
      | Tom  |
      | Beet |