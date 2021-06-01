Feature: Buy shoes upcoming on the Nike page

  Scenario Outline: Buy shoes upcoming on specific dates
    Given I visit the page nike in app
    When I look for shoes with this information in app
      | reference   | shoeSize   | user   | passwordUser   |
      | <reference> | <shoeSize> | <user> | <passwordUser> |
    Then I buy the shoes that me like in app

    Examples:
      | reference | shoeSize | user | passwordUser |
      | May7AirJordan11LowLegendBlue | M11/W12.5 | x.rodriguez2451@gmail.com | ILOVEmila2451$$ |


