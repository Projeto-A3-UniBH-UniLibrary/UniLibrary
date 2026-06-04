import java.util.Scanner;
import java.util.List;

// Classe principal que inicia o programa
// O método main é o ponto de entrada, ou seja, a primeira coisa que o Java executa
public class App {

    public static void main(String[] args) {

        // Scanner é uma classe do Java que lê o que o usuário digita no terminal
        // System.in representa a entrada padrão (teclado)
        Scanner scanner = new Scanner(System.in);

        // Cria o repositório que será usado para todas as operações no banco de dados
        Repositorio repositorio = new Repositorio();


        // Exibe o logo do sistema usando um bloco de texto (Text Block), recurso do Java 15+
        // As três aspas """ indicam o início e o fim do bloco de texto
        System.out.println("""

                ██╗   ██╗███╗   ██╗██╗██╗     ██╗██████╗ ██████╗  █████╗ ██████╗ ██╗   ██╗
                ██║   ██║████╗  ██║██║██║     ██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚██╗ ██╔╝
                ██║   ██║██╔██╗ ██║██║██║     ██║██████╔╝██████╔╝███████║██████╔╝ ╚████╔╝
                ██║   ██║██║╚██╗██║██║██║     ██║██╔══██╗██╔══██╗██╔══██║██╔══██╗  ╚██╔╝
                ╚██████╔╝██║ ╚████║██║███████╗██║██████╔╝██║  ██║██║  ██║██║  ██║   ██║
                 ╚═════╝ ╚═╝  ╚═══╝╚═╝╚══════╝╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝

                         SISTEMA DE GERENCIAMENTO DE LIVROS
                """);


        // Variável que armazena a opção escolhida pelo usuário
        // Começa em -1 para garantir que o loop while seja executado pelo menos uma vez
        int opcao = -1;


        // Loop principal do programa: continua rodando até o usuário digitar 0
        while (opcao != 0) {

            // Exibe o menu de opções a cada volta do loop
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

            // Lê a linha digitada pelo usuário e converte para número inteiro com parseInt()
            System.out.print(" Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());


            // O switch direciona o programa para o bloco correto conforme a opção escolhida
            switch (opcao) {

                case 1:
                    // Lê cada dado do livro separadamente
                    // nextLine() lê a linha inteira digitada e armazena como String
                    System.out.print(" Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print(" Autor: ");
                    String autor = scanner.nextLine();

                    // parseInt() converte o texto digitado para número inteiro
                    System.out.print(" Ano: ");
                    int ano = Integer.parseInt(scanner.nextLine());

                    System.out.print(" ISBN: ");
                    String isbn = scanner.nextLine();

                    // Chama o método adicionar do repositório que salva o livro no banco
                    repositorio.adicionar(titulo, autor, ano, isbn);
                    System.out.println(" Livro adicionado com sucesso!");
                    break;


                case 2:
                    // Chama o repositório que busca todos os livros do banco e retorna uma lista
                    List<Livro> livros = repositorio.listar();

                    // isEmpty() verifica se a lista está vazia antes de tentar exibir
                    if (livros.isEmpty()) {
                        System.out.println(" Nenhum livro cadastrado.");
                    } else {

                        // Percorre cada livro da lista pelo índice e exibe no terminal
                        // get(i) retorna o livro na posição i da lista
                        // toString() do Livro é chamado automaticamente pelo println
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println(" " + livros.get(i));
                            System.out.println("");
                        }
                    }
                    break;


                case 3:
                    // Lê o ID para identificar qual livro será atualizado
                    System.out.print(" ID do livro: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    // Lê os novos valores que substituirão os dados antigos
                    System.out.print(" Novo título: ");
                    String novoTitulo = scanner.nextLine();

                    System.out.print(" Novo autor: ");
                    String novoAutor = scanner.nextLine();

                    System.out.print(" Novo ano: ");
                    int novoAno = Integer.parseInt(scanner.nextLine());

                    System.out.print(" Novo ISBN: ");
                    String novoIsbn = scanner.nextLine();

                    // atualizar() retorna true se o livro foi encontrado e atualizado no banco
                    boolean atualizado = repositorio.atualizar(id, novoTitulo, novoAutor, novoAno, novoIsbn);

                    if (atualizado) {
                        System.out.println(" Livro atualizado com sucesso!");
                    } else {
                        System.out.println(" Livro não encontrado.");
                    }
                    break;


                case 4:
                    // Lê o ID do livro que será removido
                    System.out.print(" ID do livro: ");
                    int idRemover = Integer.parseInt(scanner.nextLine());

                    // remover() retorna true se o livro foi encontrado e removido do banco
                    boolean removido = repositorio.remover(idRemover);

                    if (removido) {
                        System.out.println(" Livro removido com sucesso!");
                    } else {
                        System.out.println(" Livro não encontrado.");
                    }
                    break;


                case 0:
                    // Encerra o loop ao digitar 0, saindo do programa
                    System.out.println(" Até logo!");
                    break;


                default:
                    // Executado quando o usuário digita um número fora das opções do menu
                    System.out.println(" Opção inválida.");
            }
        }

        // Fecha o Scanner para liberar o recurso de leitura do terminal
        scanner.close();
    }
}
