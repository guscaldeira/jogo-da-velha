import java.util.Scanner;

public class JogoDaVelha {

    static char[][] tabuleiro = new char[3][3];
    static char jogadorAtual = 'X';
    static Scanner entrada = new Scanner(System.in);
    static int rodada = 1;

    public static void main(String[] args) {
        inicializarTabuleiro();
        boolean jogoAtivo = true;

        System.out.println("=== JOGO DA VELHA ===");
        System.out.println("Jogador 1: X  |  Jogador 2: O");
        System.out.println("Linhas e colunas numeradas de 1 a 3");
        System.out.println("=====================\n");

        exibirTabuleiro();

        while (jogoAtivo) {
            System.out.println("Rodada " + rodada);
            int jogador = (jogadorAtual == 'X') ? 1 : 2;
            System.out.println("É a vez do jogador " + jogador);
            realizarJogada();

            if (verificarVitoria()) {
                exibirTabuleiro();
                int jogadorVencedor = (jogadorAtual == 'X') ? 1 : 2;
                System.out.println("Jogador " + jogadorVencedor + " ganhou!");
                jogoAtivo = false;
            } else if (verificarEmpate()) {
                exibirTabuleiro();
                System.out.println("Empate! Nenhum jogador venceu.");
                jogoAtivo = false;
            } else {
                exibirTabuleiro();
                alternarJogador();
                rodada++;
            }
        }

        entrada.close();
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
        }
        System.out.println();
    }

    // Lê e valida a jogada do jogador atual por linha e coluna
    static void realizarJogada() {
        int linha = -1;
        int coluna = -1;

        for (boolean jogadaValida = false; !jogadaValida;) {

            // Leitura da linha
            System.out.print("Linha: ");
            if (!entrada.hasNextInt()) {
                System.out.println(" Entrada inválida! Digite apenas números.");
                entrada.next();
                continue;
            }
            linha = entrada.nextInt();

            // Leitura da coluna
            System.out.print("Coluna: ");
            if (!entrada.hasNextInt()) {
                System.out.println(" Entrada inválida! Digite apenas números.");
                entrada.next();
                continue;
            }
            coluna = entrada.nextInt();

            // Validações
            if (linha < 1 || linha > 3 || coluna < 1 || coluna > 3) {
                System.out.println(" Posição inválida! Linha e coluna devem ser entre 1 e 3.");
            } else if (tabuleiro[linha - 1][coluna - 1] != ' ') {
                System.out.println(" Posição já ocupada! Escolha outra.");
            } else {
                tabuleiro[linha - 1][coluna - 1] = jogadorAtual;
                jogadaValida = true;
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
