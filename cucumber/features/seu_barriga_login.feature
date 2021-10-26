# language: pt
@login
Funcionalidade: Logar usuario

  Contexto:
    Dado que estou na pagina incial

  @logar_usuario
  Esquema do Cenario:
    Quando preencho o campo email com <email>
    E preencho o campo senha com <senha>
    E clico no botao entrar
    Entao eu sou logado com sucesso
    Exemplos:
      |           email             |      senha       |
      |  "lima.raipapai@gmail.com"  |  "PapaiJaAma123" |



