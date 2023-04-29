Feature: Place the order for Products

  @PlaceOrder
  Scenario Outline: Checkout Experience for product selected in Home page

    Given User is on GreenKart Landing page
    When User searches with shortname <Name> and extracts actual name of product
    And User added "3" items of the selected product to cart
    Then User proceeds to Checkout
    And validate the <Name> items in Checkout page
    And verify User has ability to enter promo code and place the order
    Examples:
      | Name |
      | Tom  |
      | Beet |