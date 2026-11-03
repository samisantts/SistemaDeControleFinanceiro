# 💰 Sistema de Controle Financeiro

API REST desenvolvida em Java com Spring Boot para gerenciamento de usuários, despesas e categorias, com o objetivo de facilitar a organização e o controle financeiro.

## 🚀 Tecnologias utilizadas

- **Java** — linguagem de programação.
- **Spring Boot** — desenvolvimento da API REST.
- **Spring Data JPA** — persistência e acesso aos dados.
- **PostgreSQL** — banco de dados relacional.
- **Maven** — gerenciamento de dependências.
- **Postman** — testes dos endpoints.

## 📌 Funcionalidades

### 👤 Usuários
- Cadastro de usuários.
- Atualização de dados.
- Busca de usuário por ID.
- Login com validação de e-mail e senha.
- Exclusão de usuários.
- Verificação de e-mails já cadastrados.

### 💸 Despesas
- Cadastro de despesas vinculadas a usuários.
- Listagem de despesas por usuário.
- Atualização de despesas.
- Exclusão de despesas.
- Validação do valor da despesa.
- Associação de despesas a categorias.

### 🏷️ Categorias
- Gerenciamento de categorias de despesas.
- Organização das despesas por categoria.

## 🏗️ Arquitetura do projeto

O projeto utiliza uma estrutura em camadas para separar as responsabilidades e facilitar a manutenção do código.

- **Controller:** recebe as requisições HTTP e disponibiliza os endpoints da API.
- **Service:** concentra as regras de negócio e as validações.
- **Repository:** realiza o acesso e a persistência dos dados utilizando Spring Data JPA.
- **Entity/Model:** representa as entidades do sistema e seus relacionamentos.
- **DTO (Data Transfer Object):** controla os dados recebidos e enviados pela API.
- **Mapper:** realiza a conversão entre DTOs e entidades.
- **Exception:** organiza o tratamento de erros e situações excepcionais.

## 🔧 Como executar o projeto

### Pré-requisitos

- Java instalado.
- Maven instalado ou utilização do Maven Wrapper.
- PostgreSQL instalado e em execução.
- Git instalado.

### 1. Clone o repositório

```bash
git clone https://github.com/samisantts/SistemaDeControleFinanceiro.git
```

### 2. Entre na pasta do projeto

```bash
cd SistemaDeControleFinanceiro
```

### 3. Configure o banco de dados

Configure as credenciais e a conexão com o PostgreSQL no arquivo `application.properties`, de acordo com o banco criado para o projeto.

### 4. Execute a aplicação

Com Maven instalado:

```bash
mvn spring-boot:run
```

Ou, utilizando o Maven Wrapper no Windows:

```bash
mvnw.cmd spring-boot:run
```

## 🧪 Testes da API

Os endpoints podem ser testados utilizando o Postman, enviando requisições HTTP e verificando as respostas da aplicação.

## 📚 Objetivo do projeto

Este projeto tem como objetivo consolidar conhecimentos em desenvolvimento backend com Java e Spring Boot, aplicando conceitos de Programação Orientada a Objetos, APIs REST, persistência de dados, injeção de dependência, validações, DTOs, mapeamento de objetos e tratamento de exceções.

## 👨‍💻 Autor

**Sami Gonçalves Santos**

- GitHub: [@samisantts](https://github.com/samisantts)
