Feature: Buy on the Mercado Libre page

  Scenario Outline: Buy articles Mercado Libre page
    Given I visit the page Mercado Libre in app
    When I look the articles especific with this information in app
      | user   | passwordUser   | expectedResult   |
      | <user> | <passwordUser> | <expectedResult> |
    Then I buy the article that me like in app
    And Verify the user authentication

    Examples:
      | user                   | passwordUser | expectedResult |
      | agudelo.0312@gmail.com | sebastian    | Hola Erik     |

