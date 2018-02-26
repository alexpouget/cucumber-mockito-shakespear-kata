Feature: Cocktail ordering

  fichier servant à décrire la fonctionnalité en langage naturel avec une partie description facultative
  puis des scenario s'executant a la demande
  pattern des scénario :
  given : ce que j'ai
  when : ce que je fais
  then : ce que j'obtiendrais

  as Romeo, i want to offer a drink to juliette so that we can discuss together (and maybe more)

  background fonctionne comme un beforeEach il initialise un etat avant chaque test
  Background:
    Given Romeo who wants to buy a drink


  Scenario: Creating an empty order
    When  an order is declared for Juliette
    Then  there is 0 cocktail in the order

  Scenario Outline: Sending a message with an order
    When  an order is declared for <to>
    And  a message saying "<message>" is added
    Then the ticket must say "<expected>"

    Examples:
      | to       | message     | expected                            |
      | Juliette | Wanna chat? | From Romeo to Juliette: Wanna chat? |
      | Jerry    | Hei!        | From Romeo to Jerry: Hei!           |
    # ...

