Feature: Cocktail ordering

  fichier servant à décrire la fonctionnalité en langage naturel avec une partie description facultative
  puis des scenario s'executant a la demande
  pattern des scénario :
  given : ce que j'ai
  when : ce que je fais
  then : ce que j'obtiendrais

  as Romeo, i want to offer a drink to juliette so that we can discuss together (and maybe more)

  Scenario: Creating an empty order
    Given Romeo who wants to buy a drink
    When  an order is declared for Juliette
    Then  there is 0 cocktail in the order

