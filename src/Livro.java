public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;

    public Livro(int id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo; 
    }

    public void setAutor(String autor) { 
        this.autor = autor; 
    }

    public void setAno(int ano) {
        this.ano = ano; 
    }

    @Override
    public String toString() {
        return "[%d] %s - %s (%d)".formatted(id, titulo, autor, ano);
    }
}
