Feature: Pesquisa carro
  Scenario: Pesquisar por carros sem usar filtro
    Given Dado que não informei os o filtro do carro
    When Eu clicar me pesquisar
    Then É retornado todos os carros