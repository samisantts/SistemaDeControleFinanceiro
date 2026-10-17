# 💰 Sistema de Controle Financeiro Pessoal

API REST para controlar receitas, despesas e saldo, mostrando quanto entrou, quanto saiu e para onde o dinheiro foi.

> 🚧 **Em desenvolvimento.** Projeto de estudo feito em dupla para praticar back-end com Java e Spring Boot.

## 🎯 Objetivo

Aprender back-end na prática, construindo uma aplicação completa e separando as responsabilidades em camadas.

## 🛠️ Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Postman (testes dos endpoints)
- Git e GitHub (branches `main` e `dev`)

## 🧱 Arquitetura

O projeto segue a divisão em camadas:

```
Controller  →  Service  →  Repository  →  PostgreSQL
(endpoints)    (regras)    (acesso a dados)
```

- **Controller:** recebe as requisições HTTP.
- **Service:** concentra as regras de negócio (ex.: não permitir e-mail repetido).
- **Repository:** conversa com o banco usando JPA.

## ✅ O que já funciona

- Cadastro de usuário, com verificação de e-mail já existente
- Atualização de cadastro, sem bloquear o próprio usuário ao manter o mesmo e-mail
- Consulta de usuário por id
- Persistência dos dados no PostgreSQL

## 📡 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/usuarios` | Cadastra um usuário |
| PUT | `/atualizarcadastro` | Atualiza o cadastro |
| GET | `/usuarios/{id}` | Busca um usuário pelo id |

## 🗺️ Próximos passos

- [ ] Cadastro de receitas e despesas (descrição, valor, categoria e data)
- [ ] Cálculo de total de receitas, total de despesas e saldo
- [ ] Filtro por categoria e consulta por período ou mês
- [ ] Orçamento com limite de gasto por mês
- [ ] Gasto por categoria e comparação entre meses
- [ ] Spring Security
- [ ] Testes automatizados

## ▶️ Como rodar

**Pré-requisitos:** JDK, Maven e PostgreSQL instalados.

1. Clone o repositório:
```bash
   git clone https://github.com/samisantts/SistemaDeControleFinanceiro-.git
   cd SistemaDeControleFinanceiro-
```
2. Crie um banco chamado `financeiro` no PostgreSQL.
3. Crie o arquivo `src/main/resources/application.yml` com as suas credenciais:
```y
