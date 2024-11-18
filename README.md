# Sistema de E-commerce - README

Este é um sistema de e-commerce desenvolvido em Java usando Spring Boot. A aplicação fornece uma API RESTful para gerenciar usuários, produtos, carrinhos de compras e ordens de compra.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.4
- Maven

## Estrutura do Projeto

- Controller: Contém as classes controladoras que expõem os endpoints da API.
- Domain: Contém as classes de domínio do sistema.
- Service: Contém as classes de serviço que implementam a lógica de negócios.
- Repository: Contém as classes de abstração de persistência e acesso a dados.

## Como Executar

### Pré-requisitos

- JDK 17 instalado
- Maven instalado

### Passos para Executar

#### 1. Clone o Repositório:

- git clone https://github.com/estrela2704/ArquiteturaJava.git

#### 2. Build do Projeto:

- mvn clean install

#### 3. Executar a Aplicação:

- mvn spring-boot:run

### Carregamento Inicial de Dados

A aplicação possui uma classe Loader que carrega dados iniciais a partir de um arquivo java.txt na pasta files.

### Acesso aos endpoints

Na raiz do projeto, possui um arquivo chamado ARQUITETURA_JAVA_POSTMAN_COLLECTION.json que pode ser carregado pela aplicação POSTMAN que garante a documentação dos endpoints da aplicação.

#### Este README fornece uma visão geral do sistema de e-commerce, instruções para executar a aplicação e informações sobre os endpoints disponíveis. Sinta-se à vontade para contribuir com melhorias ou relatar problemas através do repositório no GitHub.
