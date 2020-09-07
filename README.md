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
          |- justa
            |- account
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
| `vc.com.justa.account.config.Constants`                   | Representa as constantes globais da aplicação
| `vc.com.justa.account.config.CacheConfiguration`          | Realiza as configurações de Cache da aplicacao
| `vc.com.justa.account.config.JacksonConfiguration`        | Realiza as configurações do Jackson
| `vc.com.justa.account.config.DateTimeFormatConfiguration` | Realiza as configurações do DateTime para o formato ISO
| `vc.com.justa.account.config.MethodSecurityConfiguration` | Realiza as configurações no Spring Security, explicitando o medo de segurança para OAuth2

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