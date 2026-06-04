// Classe que representa um livro no sistema
// Cada objeto desta classe corresponde a um livro cadastrado no banco de dados
public class Livro {

    // Atributos privados: só podem ser acessados dentro desta classe
    // O 'private' protege os dados de serem alterados diretamente de fora da classe
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private String isbn;


    // Construtor: método chamado automaticamente ao criar um novo objeto Livro
    // Recebe todos os dados e os armazena nos atributos acima
    public Livro(int id, String titulo, String autor, int ano, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
    }


    // Getters: métodos públicos que permitem ler o valor de cada atributo privado
    // São a única forma de acessar os dados de fora da classe
    public int getId()        { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor()  { return autor; }
    public int getAno()       { return ano; }
    public String getIsbn()   { return isbn; }


    // Setters: métodos públicos que permitem alterar o valor de cada atributo privado
    // Usados pelo repositório ao atualizar os dados de um livro
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor)   { this.autor = autor; }
    public void setAno(int ano)          { this.ano = ano; }
    public void setIsbn(String isbn)     { this.isbn = isbn; }


    // toString(): define como o livro aparece quando impresso no console
    // O @Override indica que estamos substituindo o método padrão da classe Object do Java
    // formatted() substitui cada %d e %s pelos valores correspondentes na ordem
    @Override
    public String toString() {
        return "[%d] %s - %s (%d) | ISBN: %s".formatted(id, titulo, autor, ano, isbn);
    }
}
