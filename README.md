# UniLibrary

Sistema de gerenciamento de livros desenvolvido em Java puro que permite cadastrar, listar, atualizar e remover livros através de um menu interativo no terminal, com os dados salvos em um banco de dados PostgreSQL hospedado no Supabase.

---

## Integrantes

- João Pedro Bastos Neves
- Matheus Honorato Leite Teixeira
- Vitor Augusto Apolinário Andrade
- Alexander Rafael Goudet Costa

---

## Funcionalidades

- Adicionar livro com título, autor, ano e ISBN
- Listar todos os livros cadastrados
- Atualizar os dados de um livro pelo ID
- Remover um livro pelo ID

---

## Estrutura do Projeto

```
UniLibrary/
└── Main/
    ├── src/
    │   ├── App.java          — ponto de entrada, menu e interação com o usuário
    │   ├── Livro.java        — classe que representa um livro
    │   └── Repositorio.java  — comunicação com o banco de dados
    ├── lib/
    │   └── postgresql-42.7.11.jar
    └── bin/
```

---

## Tecnologias Utilizadas

- Java
- JDBC
- PostgreSQL
- Supabase
- Visual Studio Code

---

## Configuração do Banco de Dados

No painel do Supabase, acesse o SQL Editor e execute:

```sql
create table livros (
  id serial primary key,
  titulo varchar(255) not null,
  autor varchar(255) not null,
  is
```

---

## Configuração da Conexão

No arquivo Repositorio.java, substitua as credenciais com os dados do seu projeto no Supabase:

```java
private static final String URL  = "jdbc:postgresql://db.XXXXXXXX.supabase.co:5432/postgres";
private static final String USER = "postgres";
private static final String PASS = "sua-senha";
```

As credenciais podem ser encontradas em Project Settings → Database no painel do Supabase.

---

## Como Executar

Com o terminal aberto na pasta Main, rode os comandos abaixo:

Compilar:
```cmd
javac -cp "lib\postgresql-42.7.11.jar" -d bin src\*.java
```

Executar:
```cmd
java -cp "bin;lib\postgresql-42.7.11.jar" App
```

---

## Observação

Caso esteja usando o Visual Studio Code com a extensão Java instalada, basta pressionar o botão Run após configurar o arquivo .vscode/settings.json com o conteúdo abaixo:

```json
{
    "java.project.referencedLibraries": [
        "Main/lib/**/*.jar"
    ]
}
```
