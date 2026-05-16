import java.util.Scanner;

public class JogoDaVelha {

    static char[][] tabuleiro = new char[3][3];
    static char jogadorAtual = 'X';
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarTabuleiro();
        boolean jogoAtivo = true;

        System.out.println("=== JOGO DA VELHA ===");
        System.out.println("Jogador 1: X  |  Jogador 2: O");
        System.out.println("Posições do tabuleiro:");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println(" 7 | 8 | 9 ");
        System.out.println("=====================\n");

        while (jogoAtivo) {
            exibirTabuleiro();
            realizarJogada();

            if (verificarVitoria()) {
                exibirTabuleiro();
                System.out.println(" Jogador " + jogadorAtual + " venceu!");
                jogoAtivo = false;
            } else if (verificarEmpate()) {
                exibirTabuleiro();
                System.out.println(" Empate! Nenhum jogador venceu.");
                jogoAtivo = false;
            } else {
                alternarJogador();
            }
        }

        scanner.close();
    }

    // Preenche o tabuleiro com espaços vazios
    static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tabuleiro[i][j] = ' ';
    }

    // Exibe o tabuleiro formatado no console
    static void exibirTabuleiro() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tabuleiro[i][0] + " | " + tabuleiro[i][1] + " | " + tabuleiro[i][2]);
            if (i < 2)
                System.out.println("---+---+---");
        }
        System.out.println();
    }

    // Lê e valida a jogada do jogador atual
    static void realizarJogada() {
        int posicao = -1;
        boolean jogadaValida = false;

        while (!jogadaValida) {
            System.out.print("Jogador " + jogadorAtual + ", escolha uma posição (1-9): ");
            try {
                posicao = Integer.parseInt(scanner.nextLine().trim());

                if (posicao < 1 || posicao > 9) {
                    System.out.println(" Posição inválida! Digite um número de 1 a 9.");
                } else {
                    int linha = (posicao - 1) / 3;
                    int coluna = (posicao - 1) % 3;

                    if (tabuleiro[linha][coluna] != ' ') {
                        System.out.println(" Posição já ocupada! Escolha outra.");
                    } else {
                        tabuleiro[linha][coluna] = jogadorAtual;
                        jogadaValida = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida! Digite apenas números.");
            }
        }
    }

    // Verifica se o jogador atual venceu
    static boolean verificarVitoria() {
        // Linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual &&
                tabuleiro[i][1] == jogadorAtual &&
                tabuleiro[i][2] == jogadorAtual)
                return true;

            if (tabuleiro[0][i] == jogadorAtual &&
                tabuleiro[1][i] == jogadorAtual &&
                tabuleiro[2][i] == jogadorAtual)
                return true;
        }

        // Diagonal principal
        if (tabuleiro[0][0] == jogadorAtual &&
            tabuleiro[1][1] == jogadorAtual &&
            tabuleiro[2][2] == jogadorAtual)
            return true;

        // Diagonal secundária
        if (tabuleiro[0][2] == jogadorAtual &&
            tabuleiro[1][1] == jogadorAtual &&
            tabuleiro[2][0] == jogadorAtual)
            return true;

        return false;
    }

    // Verifica se todas as posições estão preenchidas (empate)
    static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tabuleiro[i][j] == ' ')
                    return false;
        return true;
    }

    // Alterna entre os jogadores X e O
    static void alternarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }
}
