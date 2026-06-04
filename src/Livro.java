public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private String isbn;

    public Livro(int id, String titulo, String autor, int ano, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
    }

    public int getId() { 
        return id; 
    }

    public String getTitulo() {
        return titulo; 
    }

    public String getAutor() { 
        return autor; 
    }

    public int getAno() { 
        return ano; 
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo; 
    }

    public void setAutor(String autor) { 
        this.autor = autor; 
    }

    public void setAno(int ano) {
        this.ano = ano; 
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "[%d] %s - %s (%d) | ISBN: %s".formatted(id, titulo, autor, ano, isbn);
    }
}
