#  Jogo da Velha — Java

Implementação do clássico Jogo da Velha em Java, com interface no terminal e suporte para dois jogadores.

---

##  Sobre o Projeto

O jogo utiliza uma **matriz 3x3** para controlar o tabuleiro e toda a lógica está concentrada em uma única classe com o método `main()`.

---

##  Estrutura da Classe — Métodos Desenvolvidos

| Método | O que faz |
|---|---|
| `main()` | Controla o loop principal do jogo |
| `inicializarTabuleiro()` | Preenche a matriz 3x3 com espaços vazios |
| `exibirTabuleiro()` | Desenha o tabuleiro formatado no console |
| `realizarJogada()` | Lê, valida e registra a jogada do jogador |
| `verificarVitoria()` | Checa linhas, colunas e diagonais |
| `verificarEmpate()` | Verifica se todas as casas estão ocupadas |
| `alternarJogador()` | Troca entre `X` e `O` a cada rodada |

---

##  Como Jogar

O tabuleiro é numerado de 1 a 9:

```
 1 | 2 | 3
---+---+---
 4 | 5 | 6
---+---+---
 7 | 8 | 9
```

- **Jogador 1** usa `X`
- **Jogador 2** usa `O`
- Os jogadores se alternam escolhendo uma posição (1–9)
- Vence quem completar uma linha, coluna ou diagonal

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

- Posição fora do intervalo (< 1 ou > 9)
- Posição já ocupada
- Entrada que não é um número

---

##  Tecnologias

- Java (JDK 8+)
- `java.util.Scanner` para leitura do terminal

---

##  Licença

Este projeto está sob a licença MIT. Sinta-se livre para usar e modificar.