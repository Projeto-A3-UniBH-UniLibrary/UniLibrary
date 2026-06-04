import java.sql.*;
import java.util.*;

// Classe responsável por se comunicar com o banco de dados
// Toda operação de salvar, buscar, atualizar ou remover livros passa por aqui
public class Repositorio {

    // Endereço do banco de dados no Supabase (formato exigido pelo driver JDBC do PostgreSQL)
    private static final String URL  = "jdbc:postgresql://db.rzqcdhtnfbihriwkwntb.supabase.co:5432/postgres";

    // Usuário do banco de dados
    private static final String USER = "postgres";

    // Senha do banco de dados
    private static final String PASS = "UniLibrary2026";


    // Abre uma conexão com o banco de dados usando as credenciais acima
    // DriverManager é uma classe do JDBC que gerencia os drivers de banco de dados
    // getConnection() tenta se conectar e lança SQLException se falhar
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }


    // Método auxiliar que executa qualquer SQL de INSERT, UPDATE ou DELETE
    // Recebe o SQL com '?' como marcadores de posição, e os valores que substituem cada '?'
    // Usar '?' em vez de concatenar strings evita ataques de SQL Injection
    private boolean executar(String sql, Object... params) {

        // try-with-resources: abre a conexão e o PreparedStatement, e os fecha automaticamente ao terminar
        // PreparedStatement é usado para executar SQL com parâmetros de forma segura
        try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Percorre a lista de parâmetros e preenche cada '?' do SQL com o valor correspondente
            // setObject() aceita qualquer tipo (String, int, etc.) e faz a conversão automaticamente
            for (int i = 0; i < params.length; i++)
                ps.setObject(i + 1, params[i]);

            // executeUpdate() executa o SQL e retorna quantas linhas foram afetadas
            // Se for maior que 0, significa que a operação funcionou
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            // getMessage() é um método da classe Exception do Java
            // Retorna a mensagem de erro gerada pelo banco de dados
            System.out.println(" Erro: " + e.getMessage());
            return false;
        }
    }


    // Insere um novo livro na tabela 'livros' do banco de dados
    public void adicionar(String titulo, String autor, int ano, String isbn) {
        executar("INSERT INTO livros (titulo, autor, ano, isbn) VALUES (?, ?, ?, ?)", titulo, autor, ano, isbn);
    }


    // Atualiza os dados de um livro existente buscando pelo ID
    // Retorna true se o livro foi encontrado e atualizado, false se o ID não existir
    public boolean atualizar(int id, String titulo, String autor, int ano, String isbn) {
        return executar("UPDATE livros SET titulo=?, autor=?, ano=?, isbn=? WHERE id=?", titulo, autor, ano, isbn, id);
    }


    // Remove um livro da tabela buscando pelo ID
    // Retorna true se o livro foi encontrado e removido, false se o ID não existir
    public boolean remover(int id) {
        return executar("DELETE FROM livros WHERE id=?", id);
    }


    // Busca todos os livros no banco e retorna uma lista com todos eles
    public List<Livro> listar() {

        // Cria uma lista vazia que será preenchida com os livros do banco
        List<Livro> livros = new ArrayList<>();

        try (Connection con = conectar();

             // createStatement() cria um comando SQL simples sem parâmetros
             // executeQuery() executa um SELECT e retorna um ResultSet com as linhas encontradas
             // ResultSet funciona como um cursor que percorre cada linha retornada pelo banco
             ResultSet rs = con.createStatement().executeQuery("SELECT * FROM livros ORDER BY id")) {

            // next() avança o cursor para a próxima linha, retorna false quando não há mais linhas
            while (rs.next())

                // Para cada linha, getString() e getInt() buscam o valor de cada coluna pelo nome
                // Um objeto Livro é criado com esses valores e adicionado à lista
                livros.add(new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano"), rs.getString("isbn")));

        } catch (SQLException e) {
            System.out.println(" Erro: " + e.getMessage());
        }

        // Retorna a lista com todos os livros encontrados
        return livros;
    }
}
