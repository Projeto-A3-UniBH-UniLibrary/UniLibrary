import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repositorio repositorio = new Repositorio();

        System.out.println("""

                ██╗   ██╗███╗   ██╗██╗██╗     ██╗██████╗ ██████╗  █████╗ ██████╗ ██╗   ██╗
                ██║   ██║████╗  ██║██║██║     ██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚██╗ ██╔╝
                ██║   ██║██╔██╗ ██║██║██║     ██║██████╔╝██████╔╝███████║██████╔╝ ╚████╔╝
                ██║   ██║██║╚██╗██║██║██║     ██║██╔══██╗██╔══██╗██╔══██║██╔══██╗  ╚██╔╝
                ╚██████╔╝██║ ╚████║██║███████╗██║██████╔╝██║  ██║██║  ██║██║  ██║   ██║
                 ╚═════╝ ╚═╝  ╚═══╝╚═╝╚══════╝╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝

                         SISTEMA DE GERENCIAMENTO DE LIVROS
                """);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                    ---------------------------------------------------------------

                    == Selecione uma das opções abaixo: ==

                     [1] Adicionar livro
                     [2] Listar livros
                     [3] Atualizar livro
                     [4] Remover livro
                     [0] Sair
                     
                    ---------------------------------------------------------------
                    """);

            System.out.print(" Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print(" Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print(" Autor: ");
                    String autor = scanner.nextLine();

                    System.out.print(" Ano: ");
                    int ano = Integer.parseInt(scanner.nextLine());

                    System.out.print(" ISBN: ");
                    String isbn = scanner.nextLine();

                    repositorio.adicionar(titulo, autor, ano, isbn);
                    System.out.println(" Livro adicionado com sucesso!");
                    break;

                case 2:
                    List<Livro> livros = repositorio.listar();
                    if (livros.isEmpty()) {
                        System.out.println(" Nenhum livro cadastrado.");
                    } else {
                    for (int i = 0; i < livros.size(); i++) {
                            System.out.println(" " + livros.get(i));
                            System.out.println("");
                        }
                    }
                    break;
                    

                case 3:
                    System.out.print(" ID do livro: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print(" Novo título: ");
                    String novoTitulo = scanner.nextLine();

                    System.out.print(" Novo autor: ");
                    String novoAutor = scanner.nextLine();

                    System.out.print(" Novo ano: ");
                    int novoAno = Integer.parseInt(scanner.nextLine());

                    System.out.print(" Novo ISBN: ");
                    String novoIsbn = scanner.nextLine();

                    boolean atualizado = repositorio.atualizar(id, novoTitulo, novoAutor, novoAno, novoIsbn);
                    if (atualizado) {
                        System.out.println(" Livro atualizado com sucesso!");
                    } else {
                        System.out.println(" Livro não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print(" ID do livro: ");
                    int idRemover = Integer.parseInt(scanner.nextLine());

                    boolean removido = repositorio.remover(idRemover);
                    if (removido) {
                        System.out.println(" Livro removido com sucesso!");
                    } else {
                        System.out.println(" Livro não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println(" Até logo!");
                    break;

                default:
                    System.out.println(" Opção inválida.");
            }
        }

        scanner.close();
    }
}
