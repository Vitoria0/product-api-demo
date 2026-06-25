# API de Produtos com Spring Boot

Projeto desenvolvido para estudo de desenvolvimento de APIs REST utilizando Spring Boot, Spring Data JPA e SQLite.

A aplicação implementa um CRUD completo de produtos, permitindo cadastrar, consultar, atualizar e remover registros através de endpoints HTTP.

## Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* SQLite
* Maven
* REST API

## Funcionalidades

* Cadastro de produtos
* Listagem de todos os produtos
* Busca de produto por ID
* Atualização de produtos
* Exclusão de produtos
* Persistência de dados em banco SQLite

## Estrutura do projeto

* **Controller**: responsável pelos endpoints da API.
* **Service**: camada de regras de negócio.
* **Repository**: acesso aos dados utilizando Spring Data JPA.
* **Model**: entidades mapeadas para o banco de dados.

## Endpoints

### Listar produtos

GET /produtos

### Buscar produto por ID

GET /produtos/{id}

### Cadastrar produto

POST /produtos

### Atualizar produto

PUT /produtos/{id}

### Excluir produto

DELETE /produtos/{id}

## Objetivo

O projeto foi criado com foco em aprendizado dos conceitos fundamentais do ecossistema Spring, incluindo injeção de dependência, arquitetura em camadas, persistência com JPA e construção de APIs REST.
