import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Livro> livros = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(String titulo, String autor, int ano) {
        livros.add(new Livro(proximoId++, titulo, autor, ano));
    }

    public List<Livro> listar() {
        return livros;
    }

    public Livro buscarPorId(int id) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == id) {
                return livros.get(i);
            }
        }
        return null;
    }

    public boolean atualizar(int id, String titulo, String autor, int ano) {
        Livro livro = buscarPorId(id);
        if (livro == null) return false;
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAno(ano);
        return true;
    }

    public boolean remover(int id) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == id) {
                livros.remove(i);
                return true;
            }
        }
        return false;
    }
}
