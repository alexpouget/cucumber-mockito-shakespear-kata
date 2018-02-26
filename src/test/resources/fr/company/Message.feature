Feature: Send Message

  Scenario Outline: Sending a message with an order

    Given <from> who wants to buy a drink
    When  an order is declared for <to>
    And  a message saying "<message>" is added
    Then the ticket must say "<expected>"

    Examples:
      | from  | to       | message     | expected                            |
      | Romeo | Juliette | Wanna chat? | From Romeo to Juliette: Wanna chat? |
      | Tom   | Jerry    | Hei!        | From Tom to Jerry: Hei!             |
    # ...