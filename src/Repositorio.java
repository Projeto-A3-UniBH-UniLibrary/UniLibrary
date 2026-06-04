import java.sql.*;
import java.util.*;

public class Repositorio {

    private static final String URL  = "jdbc:postgresql://db.rzqcdhtnfbihriwkwntb.supabase.co:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "UniLibrary2026";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    private boolean executar(String sql, Object... params) {
        try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++)
                ps.setObject(i + 1, params[i]);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(" Erro: " + e.getMessage());
            return false;
        }
    }

    public void adicionar(String titulo, String autor, int ano, String isbn) {
        executar("INSERT INTO livros (titulo, autor, ano, isbn) VALUES (?, ?, ?, ?)", titulo, autor, ano, isbn);
    }

    public boolean atualizar(int id, String titulo, String autor, int ano, String isbn) {
        return executar("UPDATE livros SET titulo=?, autor=?, ano=?, isbn=? WHERE id=?", titulo, autor, ano, isbn, id);
    }

    public boolean remover(int id) {
        return executar("DELETE FROM livros WHERE id=?", id);
    }

    public List<Livro> listar() {
        List<Livro> livros = new ArrayList<>();
        try (Connection con = conectar();
             ResultSet rs = con.createStatement().executeQuery("SELECT * FROM livros ORDER BY id")) {
            while (rs.next())
                livros.add(new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano"), rs.getString("isbn")));
        } catch (SQLException e) {
            System.out.println(" Erro: " + e.getMessage());
        }
        return livros;
    }
}
