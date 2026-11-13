Sistema de Controle Financeiro Pessoal

API REST para controlar receitas e despesas pessoais: quanto entrou, quanto saiu e para onde o dinheiro foi. Projeto de estudo de back-end com Java e Spring Boot, desenvolvido em dupla e construído por etapas.

Status: em desenvolvimento. O módulo de usuários está funcional; os módulos de despesas e categorias estão em andamento. Veja Estado atual e Próximos passos.

Sumário
Tecnologias
Arquitetura
Estrutura de pastas
Modelo de dados
Enums
Endpoints
Tratamento de erros
Como executar
Estado atual
Próximos passos
Tecnologias
Tecnologia	Uso
Java	Linguagem principal (POO)
Spring Boot	Framework da API REST
Spring Data JPA	Persistência e repositories
PostgreSQL	Banco de dados relacional
Maven	Gerenciamento de dependências e build
Lombok	Geração de getters, setters e construtores
Arquitetura

O projeto separa responsabilidades em camadas:

Requisição HTTP
│
▼
Controller   → recebe a requisição e devolve a resposta (sem regra de negócio)
│
▼
Service     → regras de negócio e validações
│
▼
Repository   → acesso ao banco via Spring Data JPA
│
▼
PostgreSQL

Outras peças:

DTOs (dto): definem o que entra e o que sai da API, sem expor as entidades (por exemplo, a senha não volta na resposta do cadastro).
Mapper (mapper): converte entre entidade e DTO.
Exceptions (exception): exceções de negócio tratadas em um único GlobalExceptionHandler.
Injeção de dependência por construtor: o Spring cria as instâncias (por exemplo, o UsuarioRepository) e entrega para quem precisa delas.
Estrutura de pastas

Pacote base: com.example.sistemacontrolefinanceiro

src/main/java/com/example/sistemacontrolefinanceiro/
├── controller/
│   ├── UsuarioController.java
│   ├── DespesaController.java
│   └── CategoriaController.java
<<<<<<< HEAD
=======

>>>>>>> 59bc937952c31fb574b48842995a6aeae79bbc8f
├── service/
│   ├── UsuarioService.java
│   ├── DespesaService.java
│   └── CategoriaService.java
<<<<<<< HEAD
├── repository/
│   ├── UsuarioRepository.java
│   └── DespesaRepository.java
=======

├── repository/
│   ├── UsuarioRepository.java
│   └── DespesaRepository.java

>>>>>>> 59bc937952c31fb574b48842995a6aeae79bbc8f
├── model/
│   ├── Usuario.java
│   ├── Despesa.java
│   └── Categoria.java
<<<<<<< HEAD
├── dto/
│   ├── UsuarioRequestDTO.java
│   └── UsuarioResponseDTO.java
├── mapper/
│   ├── UsuarioMapper.java
│   └── DespesaMapper.java
=======

├── dto/
│   ├── UsuarioRequestDTO.java
│   └── UsuarioResponseDTO.java

├── mapper/
│   ├── UsuarioMapper.java
│   └── DespesaMapper.java

>>>>>>> 59bc937952c31fb574b48842995a6aeae79bbc8f
├── enums/
│   ├── CategoriaEnum.java
│   ├── StatusPagamentoEnum.java
│   └── FormaPagamentoEnum.java
<<<<<<< HEAD
=======

>>>>>>> 59bc937952c31fb574b48842995a6aeae79bbc8f
└── exception/
├── GlobalExceptionHandler.java
├── UsuarioJaExisteException.java
├── UsuarioNaoEncontradoException.java
├── SenhaIncorretaException.java
├── CategoriaNaoExisteException.java
└── DespesaNaoEncontradaException.java
<<<<<<< HEAD
=======

>>>>>>> 59bc937952c31fb574b48842995a6aeae79bbc8f
Modelo de dados
Usuario
Campo	Tipo	Descrição
id	Long	Chave primária, gerada automaticamente
nome	String	Nome (pode se repetir)
email	String	Identificação do usuário; não pode se repetir
senha	String	Senha do usuário
Despesa
Campo	Tipo	Descrição
id	Long	Chave primária, gerada automaticamente
valor	BigDecimal	Valor gasto
descricao	String	Descrição da despesa
dataInicial	LocalDate	Data inicial
<<<<<<< HEAD
=======
dataFinal	LocalDate	Data final
>>>>>>> 59bc937952c31fb574b48842995a6aeae79bbc8f
usuarioId	Long	Id do usuário dono da despesa
categoriaEnum	CategoriaEnum	Categoria (gravada como texto no banco)
Categoria
Campo	Tipo	Descrição
id	Long	Chave primária, gerada automaticamente
nome	String	Nome da categoria
descricao	String	Descrição
usuario	Usuario	Dono da categoria (relação muitos-para-um, coluna usuario_id)
Relacionamentos
Um Usuario tem várias Categorias (Categoria.usuario).
Um Usuario tem várias Despesas (ligação pelo campo Despesa.usuarioId).
Enums

Os enums são gravados no banco pelo nome (@Enumerated(EnumType.STRING)), o que evita que dados antigos mudem de significado se a ordem dos valores for alterada.

Enum	Valores	Situação
CategoriaEnum	ALIMENTACAO, TRANSPORTE, SAUDE, EDUCACAO, LAZER, MORADIA	Em uso na Despesa
StatusPagamentoEnum	PENDENTE, PAGO, ATRASADO	Criado, ainda não usado em entidade
FormaPagamentoEnum	(a definir)	Criado, sem valores
Endpoints
Usuários: /usuarios
Método	Rota	Descrição	Corpo	Resposta
POST	/usuarios/cadastrar	Cadastra um usuário	UsuarioRequestDTO	UsuarioResponseDTO
PUT	/usuarios/atualizar	Atualiza um usuário	Usuario	Usuario
POST	/usuarios/login	Faz login	Usuario (email e senha)	Usuario
GET	/usuarios/buscar/{id}	Busca usuário por id	—	Usuario
DELETE	/usuarios/deletar/{id}	Remove um usuário	—	—

Exemplo: cadastrar usuário

http
POST /usuarios/cadastrar
Content-Type: application/json

{
"nome": "Maria Silva",
"email": "maria@email.com",
"senha": "minhasenha"
}

Resposta:

json
{
"id": 1,
"nome": "Maria Silva",
"email": "maria@email.com"
}
Despesas: /Despesas
Método	Rota	Descrição	Corpo
POST	/Despesas	Cadastra uma despesa	Despesa
PUT	/Despesas	Atualiza uma despesa	Despesa
DELETE	/Despesas	Remove uma despesa	Despesa
GET	/Despesas/usuarios/{usuarioId}/despesas	Lista as despesas de um usuário	—

Exemplo: cadastrar despesa

http
POST /Despesas
Content-Type: application/json

{
"valor": 45.90,
"descricao": "Almoço",
"dataInicial": "2026-11-12",
"dataFinal": "2026-11-12",
"usuarioId": 1,
"categoriaEnum": "ALIMENTACAO"
}
Categorias

O CategoriaController existe, mas ainda não expõe endpoints.

Tratamento de erros

As exceções de negócio são convertidas em respostas HTTP pelo GlobalExceptionHandler. O corpo da resposta é a mensagem de erro em texto.

Exceção	Status	Quando acontece
UsuarioJaExisteException	409 Conflict	Email já cadastrado
UsuarioNaoEncontradoException	404 Not Found	Usuário não existe
SenhaIncorretaException	401 Unauthorized	Senha não confere no login
CategoriaNaoExisteException	400 Bad Request	Categoria inválida
DespesaNaoEncontradaException	404 Not Found	Despesa não existe
Como executar
Pré-requisitos
JDK instalado (use a versão definida no pom.xml)
Maven
PostgreSQL
Passo a passo
Clone o repositório
bash
git clone https://github.com/samisantts/SistemaDeControleFinanceiro-.git
cd SistemaDeControleFinanceiro-
Crie o banco de dados no PostgreSQL:
sql
CREATE DATABASE financeiro;
Crie o arquivo src/main/resources/application.yml com a sua configuração local. Ele não vai para o repositório (está no .gitignore) porque contém a senha do banco:
yaml
spring:
datasource:
url: jdbc:postgresql://localhost:5432/financeiro
username: SEU_USUARIO
password: SUA_SENHA
jpa:
hibernate:
ddl-auto: update

Com ddl-auto: update, o Hibernate cria e atualiza as tabelas automaticamente.

Execute a aplicação
bash
mvn spring-boot:run

Por padrão, a API sobe em http://localhost:8080.

Teste os endpoints com o Postman (ou outro cliente HTTP) e confira os dados no pgAdmin.
Estado atual

Funcionando

Cadastro de usuário com validação de email duplicado e DTOs (a resposta não devolve a senha)
Atualização, busca por id, exclusão e login de usuário
Estrutura do módulo de despesas (entidade, repository, service e controller)
Tratamento centralizado de exceções
Enum de categorias aplicado na despesa

Limitações conhecidas

A senha ainda é salva e comparada em texto puro (sem criptografia)
atualizar, login e buscar ainda devolvem a entidade Usuario completa, incluindo a senha
Não há autenticação nem autorização: os endpoints são abertos
CategoriaController sem endpoints; DespesaMapper e FormaPagamentoEnum vazios
<<<<<<< HEAD
Nomes de rotas inconsistentes (/Despesas com maiúscula, DELETE de despesa recebendo o objeto no corpo)
=======
Nomes de rotas inconsistentes (/Despesas com maiúscula, DELETE de despesa recebendo o objeto no corpo)
>>>>>>> 59bc937952c31fb574b48842995a6aeae79bbc8f
