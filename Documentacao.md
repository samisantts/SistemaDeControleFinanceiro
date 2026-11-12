### UsuarioMapper

Criamos a classe `UsuarioMapper` para realizar a conversão dos dados de entrada e saída do usuário.

Ela possui dois métodos:

- `toEntity()`: recebe os dados do `UsuarioRequestDTO` e os transfere para a entidade `Usuario`, incluindo a senha quando necessário, como no cadastro.
- `toResponse()`: recebe a entidade `Usuario` e transfere apenas o ID, o nome e o e-mail para o `UsuarioResponseDTO`, evitando expor a senha na resposta da API.

Dessa forma, conseguimos separar os dados recebidos dos dados devolvidos pela aplicação e controlar quais informações serão retornadas ao cliente.
