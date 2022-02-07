# language: pt
# charset: UTF-8

@JIRA-002
Funcionalidade: CRUD Api Users
  Eu como cliente gostaria de consultar, alterar, criar e deletar o os dados de um usuário

  @analitico
  Cenário: CT001 - Users - Criar um novo usuário
    Dado que o usuário quer criar um novo usuário
    E o usuário informar no campo "login" o valor "RogerioTeste"
    E o usuário informar no campo "full_name" o valor "Rogerio Siqueira"
    E o usuário informar no campo "email" o valor "testeautomatizado@teste.com"
    E o usuário informar no campo "age" o valor "23"
    Quando o usuário salvar os dados
    Então o usuário deverá ver o resultado "salvo com sucesso"

  @analitico
  Cenário: CT002 - Users - Consultar um usuário existente
    Dado que o usuário quer criar um novo usuário
    E o usuário informar no campo "login" o valor "RogerioTeste"
    E o usuário informar no campo "full_name" o valor "Rogerio Siqueira"
    E o usuário informar no campo "email" o valor "testeautomatizado@teste.com"
    E o usuário informar no campo "age" o valor "23"
    Quando o usuário salvar os dados
    E o usuário buscar as informações deste mesmo usuário
    Então o usuário deverá ver o resultado "sucesso"
    E o usuário deveria ver no campo "login" o valor "RogerioTeste"
    E o usuário deveria ver no campo "full_name" o valor "Rogerio Siqueira"
    E o usuário deveria ver no campo "email" o valor "testeautomatizado@teste.com"
    E o usuário deveria ver no campo "age" o valor "23"

  @sintetico
  Cenário: CT003 - Users - Consultar dados de um usuário
    Dado que o usuário já está na base de dados
    Quando eu consultar um usuario
    Então sera apresentado todos os dados deste usuario

  @sinteticoYml
  Cenário: CT004 - Users - Consultar dados de um usuário com arquivo yml
    Dado que o usuário já está na base de dados com yml
    Quando eu consultar um usuario com yml
    Então sera apresentado todos os dados deste usuario

  @contrato
  Cenário: CT005 - Users - Verificar Schema de um endpoint
    Dado que o usuário quer criar um novo usuário
    E o usuário informar no campo "login" o valor "RogerioTeste"
    E o usuário informar no campo "full_name" o valor "Rogerio Siqueira"
    E o usuário informar no campo "email" o valor "testeautomatizado@teste.com"
    E o usuário informar no campo "age" o valor "23"
    Quando o usuário salvar os dados
    E o usuário buscar as informações deste mesmo usuário
    Então o usuário deverá ver o resultado "sucesso"
    E o usuário deverá ter um schema válido para User Json

  Cenário: CT006 - Users - Alterar um usuário existente
    Dado que o usuário quer criar um novo usuário
    E o usuário informar no campo "login" o valor "RogerioTeste"
    E o usuário informar no campo "full_name" o valor "Rogerio Siqueira"
    E o usuário informar no campo "email" o valor "testeautomatizado@teste.com"
    E o usuário informar no campo "age" o valor "23"
    Quando o usuário salvar os dados
    E o usuário informar no campo "login" o valor "RogerioAtualizado"
    E o usuário informar no campo "full_name" o valor "Rogerio Atualizado"
    E o usuário atualizar as informações deste usuário
    E o usuário buscar as informações deste mesmo usuário
    Então o usuário deverá ver o resultado "sucesso"
    E o usuário deveria ver no campo "login" o valor "RogerioAtualizado"
    E o usuário deveria ver no campo "full_name" o valor "Rogerio Atualizado"
    E o usuário deveria ver no campo "email" o valor "testeautomatizado@teste.com"
    E o usuário deveria ver no campo "age" o valor "23"

  Cenário: CT007 - Users - Deletar um usuário existente
    Dado que o usuário quer criar um novo usuário
    E o usuário informar no campo "login" o valor "RogerioAtualizado"
    E o usuário informar no campo "full_name" o valor "Rogerio Atualizado"
    E o usuário informar no campo "email" o valor "testeautomatizado@teste.com"
    E o usuário informar no campo "age" o valor "23"
    E o usuário salvar os dados
    Quando o usuário deletar as informações deste usuário
    Então o usuário deverá ver o resultado "not content"

    Quando o usuário buscar as informações deste mesmo usuário
    Então o usuário deverá ver o resultado "não encontrado"



