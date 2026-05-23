# 🎮 Jogo da Velha — Java

Implementação do clássico Jogo da Velha em Java, com interface no terminal e suporte para dois jogadores.

---

##  Sobre o Projeto

O jogo utiliza uma **matriz 3x3** para controlar o tabuleiro e toda a lógica está concentrada em uma única classe com o método `main()`. Cada jogador escolhe a posição informando a **linha** e a **coluna** separadamente, e o jogo exibe o tabuleiro atualizado após cada rodada.

---

##  Estrutura da Classe — Métodos Desenvolvidos

| Método | O que faz |
|---|---|
| `main()` | Controla o loop principal do jogo e o contador de rodadas |
| `inicializarTabuleiro()` | Preenche a matriz 3x3 com espaços vazios |
| `exibirTabuleiro()` | Desenha o tabuleiro formatado no console |
| `realizarJogada()` | Lê e valida a linha e coluna digitadas pelo jogador |
| `verificarVitoria()` | Checa linhas, colunas e diagonais |
| `verificarEmpate()` | Verifica se todas as casas estão ocupadas |
| `alternarJogador()` | Troca entre `X` e `O` a cada rodada |

---

##  Como Jogar

- **Jogador 1** usa `X`
- **Jogador 2** usa `O`
- A cada rodada, o jogador informa a **linha** (1–3) e a **coluna** (1–3) onde deseja jogar
- O tabuleiro é exibido após cada jogada
- Vence quem completar uma linha, coluna ou diagonal

### Exemplo de partida

```
=== JOGO DA VELHA ===
Jogador 1: X  |  Jogador 2: O
Linhas e colunas numeradas de 1 a 3
  |   |
  |   |  
  |   |
Rodada 1
É a vez do jogador 1
Linha: 1
Coluna: 2
  |   |
  | X |  
  |   |
Rodada 2
É a vez do jogador 2
Linha: 2
Coluna: 2
...
Jogador 1 ganhou!
```

---

##  Como Executar

**Pré-requisito:** ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado.

```bash
# Compilar
javac JogoDaVelha.java

# Rodar
java JogoDaVelha
```

---

##  Validações

- Entrada que não é um número (`hasNextInt()`)
- Linha ou coluna fora do intervalo (< 1 ou > 3)
- Posição já ocupada por outro jogador

---

##  Tecnologias

- Java (JDK 8+)
- `java.util.Scanner` para leitura do terminal

---

