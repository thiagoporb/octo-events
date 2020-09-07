# Octo Events

### Octo Events é uma API REST criada utilizando a linguagem Kotlin e os frameworks Javalin, Koin e Exposed .

### Documentação de referência
Para referências futuras por favor, considere ver as seções:

* [Javalin](https://github.com/JetBrains/kotlin) Framework web
* [Koin](https://github.com/InsertKoinIO/koin) Injeção de dependencia
* [Jackson](https://github.com/FasterXML/jackson-module-kotlin) Data Bind serialização/deserialização
* [HikariCP](https://github.com/brettwooldridge/HikariCP) Gerenciador de pool de conexões
* [PostgresSQL](https://www.postgresql.org) Banco de dados 
* [H2](https://www.h2database.com) Banco de dados para testes 
* [OpenAPI 3.0 specification](https://springdoc.org/)

Testes:

  - [junit](https://github.com/junit-team/junit4)
  - [Unirest](https://github.com/Kong/unirest-java) para invocar endpoints nos testes de integração


### Links Adicionais
Essas referências adicionais também devem ajudá-lo:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Guias de instruções

* [Estruturação](docs/instalation.md)
* [Principais pacotes]()
* [Classes de Apoio]()
* [Arquivos de Propriedades(.properties)]() 
* [Padrão de Codificação]() 
* [Ambiente de Desenvolvimento]() 
* [Gestão de Configuração](docs/gestao_configuracao.md)


# Instalação
 
## Pré-requisitos

Para executar o octo-events, você precisará das seguintes tecnologias.

1. Java 11 ou superior do [site da Oracle] (http://www.oracle.com/technetwork/java/javase/downloads/index.html)

2. Gradle 6.3 ou superior [site do Gradle] (https://docs.gradle.org/6.3/release-notes.html)

3. Clonando respositório
```bash
git clone git@github.com:thiagoporb/octo-events.git
```
4. Compilando
 ```bash
gradle build --scan
```

# Estruturação

```
|- src
  |- main
    |- java                    
      |- vc
        |- com
          |- example
            |- octoevents
              |- config         Contem as Classes de Configurações
              |- domain         Contem as Classes de Modelo de Dominio
                |- service      Contem as classes de Serviços
                |- repository   Contem a camada de persistencia e definições de tabelas
                |- dto          Contem as classes de DTO
                |- mapper       Contem as Interfaces de Mapeamento
              |- web
                |- controller   Contem as Classes Controladoras de Recursos
                  |- errors     Contem as Classes de erros seguindo a especificação RFC 7807
                  |- util       Contem as Classes Utilitarias para os Recursos                      
              
  |- resources/                 Contem os Arquivos de Propriedades(.properties)
```

# Classes de Apoio

Algumas classes de apoio foram previamente disponibilizadas, visando padronização e produtividade através do reuso. As principais classes são: 

| Classe                                                    | Descrição           
------------------------------------------------------------|---------------------------------------------------------------------------------------
| `com.example.octoevents.config.AppConfig`                   | Realiza as configurações do servidor
| `com.example.octoevents.config.DatabaseConfig`              | Realiza as configurações do banco de dados
| `com.example.octoevents.config.ModulesConfig`               | Realiza as configurações dos modulos para injeção de dependencia
| `com.example.octoevents.config.OpenApiConfig`               | Realiza as configurações da especificação Open Api

# Docker e Docker Compose

## Construindo e executando a imagem do Docker
Para criar uma imagem Docker utilizamos [Jib](https://spring.io/guides/gs/rest-service/) conectando-se ao daemon do Docker local:

Com o Gradle digitando o seguinte comando: 
 ```bash
./gradlew -Pprod bootJar jibDockerBuild
```

Para executar esta imagem, use a configuração do Docker Compose localizada na pasta **src/main/docker** do projeto:
 ```bash
docker-compose -f src/main/docker/app.yml up
```

### Postgres

A execução docker-compose -f src/main/docker/app.yml up já inicia o postgres automaticamente.

Se você deseja iniciar apenas o postgres, e não os outros serviços, use a configuração do Docker Compose do Postgres:
 ```bash
docker-compose -f src/main/docker/postgresql.yml up
```

### Sonar

Uma configuração do Docker Compose é gerada para a execução do Sonar:
 ```bash
docker-compose -f src/main/docker/sonar.yml up
```
Para analisar o código, execute o Sonar em seu projeto:

Com Gradle:
 ```bash
./gradlew sonar
```

# API

## Webhook Endpoint

Este endpoint recebe e valida os eventos do tipo IssueEvent postados pelo Github, gravando-os no banco de dados para serem consultados posteriormente.

**Endpoint:** POST  [http://localhost:7000/api/events](http://localhost:7000/api/events)

**Formato:**

Este é um exemplo de JSON enviado pelo Github:

```
{
  "action": "edited",
  "issue": {
    "url": "https://api.github.com/repos/Codertocat/Hello-World/issues/1",
    "repository_url": "https://api.github.com/repos/Codertocat/Hello-World",
    "labels_url": "https://api.github.com/repos/Codertocat/Hello-World/issues/1/labels{/name}",
    "comments_url": "https://api.github.com/repos/Codertocat/Hello-World/issues/1/comments",
    "events_url": "https://api.github.com/repos/Codertocat/Hello-World/issues/1/events",
    "html_url": "https://github.com/Codertocat/Hello-World/issues/1",
    "id": 444500041,
    "node_id": "MDU6SXNzdWU0NDQ1MDAwNDE=",
    "number": 1,
    "title": "Spelling error in the README file",
    "user": {
      "login": "Codertocat",
      "id": 21031067,
      "node_id": "MDQ6VXNlcjIxMDMxMDY3",
      "avatar_url": "https://avatars1.githubusercontent.com/u/21031067?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/Codertocat",
      "html_url": "https://github.com/Codertocat",
      "followers_url": "https://api.github.com/users/Codertocat/followers",
      "following_url": "https://api.github.com/users/Codertocat/following{/other_user}",
      "gists_url": "https://api.github.com/users/Codertocat/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/Codertocat/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/Codertocat/subscriptions",
      "organizations_url": "https://api.github.com/users/Codertocat/orgs",
      "repos_url": "https://api.github.com/users/Codertocat/repos",
      "events_url": "https://api.github.com/users/Codertocat/events{/privacy}",
      "received_events_url": "https://api.github.com/users/Codertocat/received_events",
      "type": "User",
      "site_admin": false
    },
    "labels": [
      {
        "id": 1362934389,
        "node_id": "MDU6TGFiZWwxMzYyOTM0Mzg5",
        "url": "https://api.github.com/repos/Codertocat/Hello-World/labels/bug",
        "name": "bug",
        "color": "d73a4a",
        "default": true
      }
    ],
    "state": "open",
    "locked": false,
    "assignee": {
      "login": "Codertocat",
      "id": 21031067,
      "node_id": "MDQ6VXNlcjIxMDMxMDY3",
      "avatar_url": "https://avatars1.githubusercontent.com/u/21031067?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/Codertocat",
      "html_url": "https://github.com/Codertocat",
      "followers_url": "https://api.github.com/users/Codertocat/followers",
      "following_url": "https://api.github.com/users/Codertocat/following{/other_user}",
      "gists_url": "https://api.github.com/users/Codertocat/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/Codertocat/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/Codertocat/subscriptions",
      "organizations_url": "https://api.github.com/users/Codertocat/orgs",
      "repos_url": "https://api.github.com/users/Codertocat/repos",
      "events_url": "https://api.github.com/users/Codertocat/events{/privacy}",
      "received_events_url": "https://api.github.com/users/Codertocat/received_events",
      "type": "User",
      "site_admin": false
    },
    "assignees": [
      {
        "login": "Codertocat",
        "id": 21031067,
        "node_id": "MDQ6VXNlcjIxMDMxMDY3",
        "avatar_url": "https://avatars1.githubusercontent.com/u/21031067?v=4",
        "gravatar_id": "",
        "url": "https://api.github.com/users/Codertocat",
        "html_url": "https://github.com/Codertocat",
        "followers_url": "https://api.github.com/users/Codertocat/followers",
        "following_url": "https://api.github.com/users/Codertocat/following{/other_user}",
        "gists_url": "https://api.github.com/users/Codertocat/gists{/gist_id}",
        "starred_url": "https://api.github.com/users/Codertocat/starred{/owner}{/repo}",
        "subscriptions_url": "https://api.github.com/users/Codertocat/subscriptions",
        "organizations_url": "https://api.github.com/users/Codertocat/orgs",
        "repos_url": "https://api.github.com/users/Codertocat/repos",
        "events_url": "https://api.github.com/users/Codertocat/events{/privacy}",
        "received_events_url": "https://api.github.com/users/Codertocat/received_events",
        "type": "User",
        "site_admin": false
      }
    ],
    "milestone": {
      "url": "https://api.github.com/repos/Codertocat/Hello-World/milestones/1",
      "html_url": "https://github.com/Codertocat/Hello-World/milestone/1",
      "labels_url": "https://api.github.com/repos/Codertocat/Hello-World/milestones/1/labels",
      "id": 4317517,
      "node_id": "MDk6TWlsZXN0b25lNDMxNzUxNw==",
      "number": 1,
      "title": "v1.0",
      "description": "Add new space flight simulator",
      "creator": {
        "login": "Codertocat",
        "id": 21031067,
        "node_id": "MDQ6VXNlcjIxMDMxMDY3",
        "avatar_url": "https://avatars1.githubusercontent.com/u/21031067?v=4",
        "gravatar_id": "",
        "url": "https://api.github.com/users/Codertocat",
        "html_url": "https://github.com/Codertocat",
        "followers_url": "https://api.github.com/users/Codertocat/followers",
        "following_url": "https://api.github.com/users/Codertocat/following{/other_user}",
        "gists_url": "https://api.github.com/users/Codertocat/gists{/gist_id}",
        "starred_url": "https://api.github.com/users/Codertocat/starred{/owner}{/repo}",
        "subscriptions_url": "https://api.github.com/users/Codertocat/subscriptions",
        "organizations_url": "https://api.github.com/users/Codertocat/orgs",
        "repos_url": "https://api.github.com/users/Codertocat/repos",
        "events_url": "https://api.github.com/users/Codertocat/events{/privacy}",
        "received_events_url": "https://api.github.com/users/Codertocat/received_events",
        "type": "User",
        "site_admin": false
      },
      "open_issues": 1,
      "closed_issues": 0,
      "state": "closed",
      "created_at": "2019-05-15T15:20:17Z",
      "updated_at": "2019-05-15T15:20:18Z",
      "due_on": "2019-05-23T07:00:00Z",
      "closed_at": "2019-05-15T15:20:18Z"
    },
    "comments": 0,
    "created_at": "2019-05-15T15:20:18Z",
    "updated_at": "2019-05-15T15:20:18Z",
    "closed_at": null,
    "author_association": "OWNER",
    "body": "It looks like you accidently spelled 'commit' with two 't's."
  },
  "changes": {
  },
  "repository": {
    "id": 186853002,
    "node_id": "MDEwOlJlcG9zaXRvcnkxODY4NTMwMDI=",
    "name": "Hello-World",
    "full_name": "Codertocat/Hello-World",
    "private": false,
    "owner": {
      "login": "Codertocat",
      "id": 21031067,
      "node_id": "MDQ6VXNlcjIxMDMxMDY3",
      "avatar_url": "https://avatars1.githubusercontent.com/u/21031067?v=4",
      "gravatar_id": "",
      "url": "https://api.github.com/users/Codertocat",
      "html_url": "https://github.com/Codertocat",
      "followers_url": "https://api.github.com/users/Codertocat/followers",
      "following_url": "https://api.github.com/users/Codertocat/following{/other_user}",
      "gists_url": "https://api.github.com/users/Codertocat/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/Codertocat/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/Codertocat/subscriptions",
      "organizations_url": "https://api.github.com/users/Codertocat/orgs",
      "repos_url": "https://api.github.com/users/Codertocat/repos",
      "events_url": "https://api.github.com/users/Codertocat/events{/privacy}",
      "received_events_url": "https://api.github.com/users/Codertocat/received_events",
      "type": "User",
      "site_admin": false
    },
    "html_url": "https://github.com/Codertocat/Hello-World",
    "description": null,
    "fork": false,
    "url": "https://api.github.com/repos/Codertocat/Hello-World",
    "forks_url": "https://api.github.com/repos/Codertocat/Hello-World/forks",
    "keys_url": "https://api.github.com/repos/Codertocat/Hello-World/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/Codertocat/Hello-World/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/Codertocat/Hello-World/teams",
    "hooks_url": "https://api.github.com/repos/Codertocat/Hello-World/hooks",
    "issue_events_url": "https://api.github.com/repos/Codertocat/Hello-World/issues/events{/number}",
    "events_url": "https://api.github.com/repos/Codertocat/Hello-World/events",
    "assignees_url": "https://api.github.com/repos/Codertocat/Hello-World/assignees{/user}",
    "branches_url": "https://api.github.com/repos/Codertocat/Hello-World/branches{/branch}",
    "tags_url": "https://api.github.com/repos/Codertocat/Hello-World/tags",
    "blobs_url": "https://api.github.com/repos/Codertocat/Hello-World/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/Codertocat/Hello-World/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/Codertocat/Hello-World/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/Codertocat/Hello-World/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/Codertocat/Hello-World/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/Codertocat/Hello-World/languages",
    "stargazers_url": "https://api.github.com/repos/Codertocat/Hello-World/stargazers",
    "contributors_url": "https://api.github.com/repos/Codertocat/Hello-World/contributors",
    "subscribers_url": "https://api.github.com/repos/Codertocat/Hello-World/subscribers",
    "subscription_url": "https://api.github.com/repos/Codertocat/Hello-World/subscription",
    "commits_url": "https://api.github.com/repos/Codertocat/Hello-World/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/Codertocat/Hello-World/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/Codertocat/Hello-World/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/Codertocat/Hello-World/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/Codertocat/Hello-World/contents/{+path}",
    "compare_url": "https://api.github.com/repos/Codertocat/Hello-World/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/Codertocat/Hello-World/merges",
    "archive_url": "https://api.github.com/repos/Codertocat/Hello-World/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/Codertocat/Hello-World/downloads",
    "issues_url": "https://api.github.com/repos/Codertocat/Hello-World/issues{/number}",
    "pulls_url": "https://api.github.com/repos/Codertocat/Hello-World/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/Codertocat/Hello-World/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/Codertocat/Hello-World/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/Codertocat/Hello-World/labels{/name}",
    "releases_url": "https://api.github.com/repos/Codertocat/Hello-World/releases{/id}",
    "deployments_url": "https://api.github.com/repos/Codertocat/Hello-World/deployments",
    "created_at": "2019-05-15T15:19:25Z",
    "updated_at": "2019-05-15T15:19:27Z",
    "pushed_at": "2019-05-15T15:20:13Z",
    "git_url": "git://github.com/Codertocat/Hello-World.git",
    "ssh_url": "git@github.com:Codertocat/Hello-World.git",
    "clone_url": "https://github.com/Codertocat/Hello-World.git",
    "svn_url": "https://github.com/Codertocat/Hello-World",
    "homepage": null,
    "size": 0,
    "stargazers_count": 0,
    "watchers_count": 0,
    "language": null,
    "has_issues": true,
    "has_projects": true,
    "has_downloads": true,
    "has_wiki": true,
    "has_pages": true,
    "forks_count": 0,
    "mirror_url": null,
    "archived": false,
    "disabled": false,
    "open_issues_count": 1,
    "license": null,
    "forks": 0,
    "open_issues": 1,
    "watchers": 0,
    "default_branch": "master"
  },
  "sender": {
    "login": "Codertocat",
    "id": 21031067,
    "node_id": "MDQ6VXNlcjIxMDMxMDY3",
    "avatar_url": "https://avatars1.githubusercontent.com/u/21031067?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/Codertocat",
    "html_url": "https://github.com/Codertocat",
    "followers_url": "https://api.github.com/users/Codertocat/followers",
    "following_url": "https://api.github.com/users/Codertocat/following{/other_user}",
    "gists_url": "https://api.github.com/users/Codertocat/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/Codertocat/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/Codertocat/subscriptions",
    "organizations_url": "https://api.github.com/users/Codertocat/orgs",
    "repos_url": "https://api.github.com/users/Codertocat/repos",
    "events_url": "https://api.github.com/users/Codertocat/events{/privacy}",
    "received_events_url": "https://api.github.com/users/Codertocat/received_events",
    "type": "User",
    "site_admin": false
  }
}
```

### Tipos de Response:

Algumas classes de apoio foram previamente disponibilizadas, visando padronização e produtividade através do reuso. As principais classes são: 

| Código           | Resultado           
-------------------|------------------------------------------------------
| `201`            | Evento validado e persistido.
| `400`            | Evento inválido, não foi inserido no banco de dados.
| `500`            | Erro inesperado do servidor.

### Listar Eventos Endpoint
Este endpoint lista todos os eventos associados a uma Issue.

**Endpoint:** GET http://localhost:7000/api/issues/{numeroIssue}/events

**Formato:**

Este é um exemplo de response deste endpoint:

### Tipos de Response: 

Algumas classes de apoio foram previamente disponibilizadas, visando padronização e produtividade através do reuso. As principais classes são: 

| Código           | Resultado           
-------------------|---------------------------------------------------------
| `200`            | Ao menos um Evento foi encontrado.
| `400`            | Parâmetro (PARAM) inválido. Deve ser um número positivo.
| `404`            | Nenhum evento encontrado.
| `500`            | Erro inesperado do servidor.