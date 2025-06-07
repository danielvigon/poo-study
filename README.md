# Objetivos

Criar um sistema simples de **controle de estoque** utilizando os conceitos de **Programação Orientada a Objetos (POO)**, como classes, objetos, encapsulamento, métodos, construtores e listas (ArrayList).

# Enunciado

Você foi contratado para desenvolver um sistema básico de controle de estoque para uma loja. O sistema deverá permitir:

- Cadastrar produtos no estoque (cadastrar em uma lista).
- A lista de produtos deverá ter os seguintes campos: código, nome, quantidade e preço.
- Listar todos os produtos cadastrados.
- Atualizar o estoque de um produto (entrada ou saída).
- Remover um produto do estoque.
- Buscar um produto pelo código.

# Especificações

## Classe Produto

Crie uma classe **Produto** com os seguintes atributos:

- `int codigo`
- `String nome`
- `double preco`
- `int quantidade`

Inclua:

- Construtor
- Métodos getters e setters
- Um método `exibirInfo()` que retorna as informações do produto.

## Classe Estoque

Crie uma classe **Estoque** que gerencie uma lista de produtos:

- Atributo: `ArrayList<Produto> produtos`

Métodos:

- `void adicionarProduto(Produto p)`
- `void removerProduto(int codigo)`
- `Produto buscarProduto(int codigo)`
- `void listarProdutos()`
- `void atualizarEstoque(int codigo, int quantidade, boolean entrada)`  
  (se `entrada = true`, aumenta o estoque; se `false`, reduz)

## Classe Main

Crie uma classe **Main** com um menu interativo no console:

Exemplo de menu:
<ol>
  <li>Adicionar Produto</li>
  <li>Listar Produtos</li>
  <li>Atualizar Estoque</li>
  <li>Remover Produto</li>
  <li>Buscar Produto</li>
  <li value="0">Sair</li>
</ol>

- Use `Scanner` para ler as opções e interagir com o usuário.

# Requisitos mínimos

- Aplicar encapsulamento corretamente.
- Usar listas para armazenar os produtos.
- Usar `switch` para o menu.
- Validar entradas básicas (como produto não encontrado).

# Dica para os alunos

Você pode ir além e adicionar:

- Salvar os dados em arquivo texto.
- Atualizar preços.
- Relatórios com produtos com estoque baixo.