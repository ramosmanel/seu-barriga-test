#language: pt
  Funcionalidade: Cadastrar uma conta
    Contexto:
      Dado que estou na pagina incial

    @cadastrar_usuario
    Esquema do Cenario:
    E seleciono novo usuario
    Quando eu preencho o campo nome com <nome>
    E preencho o campo email com <email>
    E preencho o campo senha com <senha>
    E clico no botao cadastrar
    Entao sou cadastrado com sucesso
      Exemplos:
        |     nome    |             email              |      senha     |
        |  "Rai Lima" |    "lima.raipapai@gmail.com"   | "PapaiJaAma123"|

