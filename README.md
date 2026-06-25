# API de Produtos com Spring Boot

Projeto desenvolvido para estudo de desenvolvimento backend utilizando Java e Spring Boot. A aplicação implementa uma API REST completa para gerenciamento de produtos, seguindo arquitetura em camadas e boas práticas de desenvolvimento.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- SQLite
- Maven
- REST API
- JUnit 5
- Mockito

## Funcionalidades

- Cadastro de produtos
- Listagem de produtos
- Busca de produto por ID
- Atualização de produtos
- Exclusão de produtos
- Persistência de dados em SQLite
- Consumo da API através de cliente Java utilizando RestTemplate
- Testes unitários da camada de serviço

## Arquitetura

O projeto segue o padrão de arquitetura em camadas:

```text
Controller
   ↓
Service
   ↓
Repository
   ↓
Banco de Dados (SQLite)
```

### Camadas

- **Controller**: exposição dos endpoints REST.
- **Service**: regras de negócio.
- **Repository**: acesso aos dados utilizando Spring Data JPA.
- **Model**: entidades da aplicação.
- **Client**: consumo da API utilizando RestTemplate.

## Endpoints

| Método | Endpoint | Descrição |
|----------|----------|----------|
| GET | /produtos | Lista todos os produtos |
| GET | /produtos/{id} | Busca produto por ID |
| POST | /produtos | Cadastra um produto |
| PUT | /produtos/{id} | Atualiza um produto |
| DELETE | /produtos/{id} | Remove um produto |

## Exemplo de Produto

```json
{
  "nome": "Notebook",
  "quantidade": 10,
  "preco": 4500.00,
  "status": "ATIVO"
}
```

## Cliente Java

O projeto possui um cliente Java que consome os endpoints da API utilizando `RestTemplate`, permitindo:

- Listar produtos
- Buscar produto por ID
- Cadastrar produtos
- Atualizar produtos
- Excluir produtos

## Testes

Foram implementados testes unitários utilizando:

- JUnit 5
- Mockito

Os testes validam:

- Listagem de produtos
- Cadastro de produtos
- Busca por ID
- Atualização de produtos
- Exclusão de produtos
- Tratamento de exceções

## Objetivo do Projeto

Este projeto foi desenvolvido com foco em aprendizado e prática dos principais conceitos do ecossistema Spring, incluindo:

- Injeção de Dependências (DI)
- Spring Data JPA
- Hibernate
- APIs REST
- Persistência de dados
- Testes unitários
- Consumo de APIs com RestTemplate
- Arquitetura em camadas
