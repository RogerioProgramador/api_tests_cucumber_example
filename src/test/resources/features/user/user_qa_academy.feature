# charset: UTF-8

@JIRA-001
Feature: CRUD QA Academy

  Scenario: Cucumber Example
    Given the user is on the table
    When the user get out
    Then shee should see the window

  Scenario: CT001 - Simple user post
    Given the user wants to create a new user
    And the user fills field "login" with value equal "Rogerio"
    And the user fills field "full_name" with value equal "Rogerio Teste"
    And the user fills field "age" with value equal "10"
    And the user fills field "email" with value equal "Rogerio@gft.com"
    When the user saves new user
    Then the user should see "save with success" message

  Scenario: CT002 - Simple user get
    Given the user wants to create a new user
    And the user fills field "login" with value equal "Rogerio"
    And the user fills field "full_name" with value equal "Rogerio Teste"
    And the user fills field "age" with value equal "24"
    And the user fills field "email" with value equal "Rogerio@gft.com"
    And the user saves new user
    When the user gets the same user
    Then the user should see "success" message
    And the user should see field "login" with value "Rogerio"
    And the user should see field "full_name" with value "Rogerio Teste"
    And the user should see field "age" with value "24"
    And the user should see field "email" with value "Rogerio@gft.com"

  Scenario: CT003 - Simple user put
    Given the user wants to create a new user
    And the user fills field "login" with value equal "Rogerio"
    And the user fills field "full_name" with value equal "Rogerio Teste"
    And the user fills field "age" with value equal "24"
    And the user fills field "email" with value equal "Rogerio@gft.com"
    And the user saves new user
    And the user fills field "login" with value equal "ironmano"
    When the user puts the same user
    And the user gets the same user
    Then the user should see "success" message
    And the user should see field "login" with value "ironmano"
    And the user should see field "full_name" with value "Rogerio Teste"
    And the user should see field "age" with value "24"
    And the user should see field "email" with value "Rogerio@gft.com"

  Scenario: CT004 - Simple user delete
    Given the user wants to create a new user
    And the user fills field "login" with value equal "Rogerio"
    And the user fills field "full_name" with value equal "Rogerio Teste"
    And the user fills field "age" with value equal "24"
    And the user fills field "email" with value equal "Rogerio@gft.com"
    And the user saves new user
    When the user deletes the same user
    Then the user should see "not content" message
    When the user gets the same user
    Then the user should see "not found" message

  Scenario: CT005 - Simple user contract
    Given the user wants to create a new user
    And the user fills field "login" with value equal "Rogerio"
    And the user fills field "full_name" with value equal "Rogerio Teste"
    And the user fills field "age" with value equal "24"
    And the user fills field "email" with value equal "Rogerio@gft.com"
    And the user saves new user
    When the user gets the same user
    Then the user should see your schema

  Scenario: CT006 - Simple builder and environment data
    Given the user wants to create a new user
    And the user fills all fields
    And the user saves new user
    When the user gets the same user
    Then the user should see "success" message
    And the user should see field "login" with value "dadosdev"
    And the user should see field "full_name" with value "Dados Dev"
    And the user should see field "age" with value "43"
    And the user should see field "email" with value "dados.dev@gft.com"