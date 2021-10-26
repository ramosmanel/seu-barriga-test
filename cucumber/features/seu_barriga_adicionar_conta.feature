# language: pt
@login
Funcionalidade: Adicionar uma conta nova

  Contexto:
    Dado que estou logado
    Quando clico em contas

  @adicionar_conta
  Esquema do Cenario:
    E clico em adicionar
    E escrevo no campo nome <nomeConta>
    E clico em salvar
    Entao minha conta e criada com sucesso
    Exemplos:
    |         nomeConta        |
    |       "BoavistaBank"     |


  @listar_conta
  Cenario: Mostrar as contas criadas em forma de lista
    Entao eu vejo as contas em forma de lista

  @editar_conta
    Esquema do Cenario:
    Dado que eu veja as contas em forma de lista
    Quando clico em alterar
    E escrevo o nome da conta <nomeContaAlterada>
    E clico em salvar
    Entao o nome da conta e alterado
    Exemplos:
      |         nomeContaAlterada        |
      |            "Boavista"            |




