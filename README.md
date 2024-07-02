# ExercicioUsuario

Neste exercicio foi desenvolvido um CRUD simples , ainda sem implementação do banco de dados.

Funcionalidades:

    POST `/api/users`
    Criar um novo usuário com informações fornecidas no corpo da requisição.
    Retorna status HTTP 201 (Criado) quando o usuário é criado com sucesso.

    GET `/api/users`
    Retorna uma lista de usuários cadastrados no sistema.
    Retorna um array JSON contendo todos os objetos `Usuario`.

    PUT `/api/users/{id}`
    Atualiza as informações de um usuário existente identificado pelo `{id}` especificado.
    Retorna o objeto `Usuario`atualizado após a operação de atualização.

    DELETE `/api/users{id}`
    Remove o usuário identificado pelo `{id}`especificado.
    Retorna status HTTP 200 (OK) se o usuário foi removido com sucesso.
