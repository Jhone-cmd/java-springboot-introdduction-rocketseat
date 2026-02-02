# TodoList

**Descrição:**

Este projeto é um gerenciador simples de tarefas (TodoList) feito como exercício acompanhando as aulas da plataforma RocketSeat. É uma aplicação Java Spring Boot que expõe endpoints REST para criação, leitura, atualização e remoção de tarefas, além de endpoints para gerenciamento de usuários.

**Resumo das funcionalidades:**

- **CRUD de tarefas:** criar, listar, atualizar e remover tarefas.
- **CRUD de usuários:** endpoints para criar e listar usuários (base para autenticação/autorização simples).
- **Autorização/Filtragem:** filtro que valida tokens/autorização para acesso a rotas de tarefas.
- **Tratamento centralizado de erros:** controlador que intercepta exceções e retorna respostas padronizadas.

**Tecnologias:**

- Java 17 (ou versão configurada no projeto)
- Spring Boot
- Maven (scripts via `./mvnw`)

**Como rodar:**

1. Build com Maven:

```bash
./mvnw clean package
```

2. Rodar a aplicação:

```bash
./mvnw spring-boot:run
```

ou executar o JAR gerado em `target`:

```bash
java -jar target/TodoList-0.0.1-SNAPSHOT.jar
```

**Estrutura de pastas e arquivos principais:**

- `src/main/java/com/jhone_cmd/TodoList/` : pacote raiz da aplicação.
  - `TodoListApplication.java` : classe principal (ponto de entrada Spring Boot).
  - `errors/ExceptionHandlerController.java` : controlador que centraliza o tratamento de exceções e cria respostas HTTP padronizadas.
  - `Filter/FilterTaskAuth.java` : filtro responsável por validar autorização (por exemplo, checar tokens/headers) antes de permitir acesso às rotas de tarefas.
  - `tasks/`
    - `ITaskRepository.java` : interface de acesso a dados para `Task`.
    - `TaskController.java` : endpoints REST para operações sobre tarefas.
    - `TaskModel.java` : modelo/entidade que representa uma tarefa.
  - `users/`
    - `IUserRepository.java` : interface de acesso a dados para `User`.
    - `UserController.java` : endpoints REST para operações sobre usuários.
    - `UserModel.java` : modelo/entidade que representa um usuário.
  - `Utils/Utils.java` : utilitários compartilhados pela aplicação.

- `src/main/resources/application.properties` : configurações do Spring Boot e da aplicação.

Além desses, a pasta `target/` contém a build gerada pelo Maven.

**Detalhes sobre tratamento de erros:**

- O arquivo `errors/ExceptionHandlerController.java` centraliza o manejo das exceções lançadas pela aplicação. Ele captura exceções específicas (por exemplo, validações, recursos não encontrados, erros de autenticação) e retorna um JSON com estrutura padronizada contendo código HTTP, mensagem e dados adicionais quando aplicável.
- Recomenda-se que os controllers e serviços lancem exceções específicas (por exemplo, `ResourceNotFoundException`, `BadRequestException`) que sejam mapeadas no `ExceptionHandlerController` para respostas claras ao cliente.
- Em caso de erro não esperado, o controlador de exceção devolve um HTTP 500 com mensagem genérica e, se apropriado, um identificador de correlação para debugging.

**Autorização / Filtros:**

- `FilterTaskAuth` intercepta as requisições às rotas protegidas e valida a presença/validade de credenciais (por exemplo, token no header `Authorization`).
- Se a validação falhar, o filtro interrompe a cadeia e retorna um HTTP 401/403 com mensagem adequada; caso passe, a requisição segue para os controllers.

**Pontos importantes / Observações:**

- Este projeto foi desenvolvido como parte de estudos, assistindo às aulas da RocketSeat.
- Para estender a autenticação, integrar com JWT, OAuth2 ou um provedor externo, implemente a validação no `FilterTaskAuth` e armazene/valide usuários no `IUserRepository`.
- Validações de entrada (ex.: campos obrigatórios em criação/atualização) devem ser feitas via anotações de validação do Spring (`@Valid`, `@NotNull`, etc.) e mapeadas pelo `ExceptionHandlerController` para respostas amigáveis.

**Como contribuir / testes rápidos:**

- Rodar testes (se existirem):

```bash
./mvnw test
```

- Para alterar a configuração ou portas, editar `src/main/resources/application.properties`.

**Contato / Autor:**

- Projeto criado pelo desenvolvedor acompanhando as aulas da RocketSeat.


Licença
-------
Projeto educacional — sinta-se à vontade para modificar e usar como base para aprendizado.
