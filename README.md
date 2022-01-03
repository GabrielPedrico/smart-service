# Smart-service
API para o back-end da smart-service.

# Sobre:
Esta API é um projeto academico, api que será responsável pelo back-end
de um sistema web de cardapio e atendimento para restaurantes.

# Tecnologias:

![Alt text](https://1.bp.blogspot.com/-QXQ_jdU0Frs/V46c6ImU4JI/AAAAAAAAAkM/u0xcOFxDC1gCJFc-36VOX_Ioc7pVpDOHACLcB/s200/Java%2BRuntime%2BEnvironment.png)![Alt text](https://www.dariawan.com/media/images/tutorial-spring-logo.width-400.png)![Alt text](https://pngimg.com/uploads/mysql/mysql_PNG9.png)![Alt text](https://cloudnesil.com/wp-content/uploads/2018/12/docker.png)

# Endpoints

# http://localhost:8080/cadastra/cliente [POST]

Entrada:
{
    "nome": "Nome Usuario",
    "email": "emailvalido@hotmail.com",
    "password": "123456",
    "telefone": "13999999999",
    "logradouro": "Rua Do Usuario",
    "numero": "01-B",
    "complemento": "Bloco X",
    "cep": "12045000",
    "bairro": "Gonzaga",
    "cidade": "Santos",
    "estado": "SP"
}


Saida(201):
{
    "data": [
        {
            "message": "PROCESSAMENTO OK"
        }
    ]
}

# http://localhost:8080/cadastra/administrador [POST]

Entrada:
{
    "nome": "Nome Administrador",
    "email": "emailvalido@hotmail.com",
    "password": "123456",
    "telefone": "13999999999",
    "logradouro": "Rua Do Administrador",
    "numero": "01-B",
    "complemento": "Bloco X",
    "cep": "12045000",
    "bairro": "Gonzaga",
    "cidade": "Santos",
    "estado": "SP"
}

Saida(201):
{
    "data": [
        {
            "message": "PROCESSAMENTO OK"
        }
    ]
}

# http://localhost:8080/auth [POST]

Entrada:
{
    "email" : "seuemailcadastrado@email.com",
    "password" : "suasenhacadastrada"
}


Saida(200):
{
    "data": [
        {
            "message": "AUTENTICACAO OK"
        }
    ]
}

# http://localhost:8080/cadastra/produto [POST]

Entrada:
{
    "categoria": "PODRAO",
    "nome": "Hamburguer",
    "preco": "12.99",
    "descricao": "xxxxxxxxxxxxxxxxxxxxxxxx",
    "estoque": "20"
}


Saida(201):
{
    "data": [
        {
            "message": "PROCESSAMENTO OK"
        }
    ]
}

# http://localhost:8080/cadastra/imagem/produto/{id} [PUT]

Entrada(Multipartfile):

form-data: file

Sáida(202):
{
    "data": [
        {
            "message": "PROCESSAMENTO OK"
        }
    ]
}


