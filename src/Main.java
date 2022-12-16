import java.util.Scanner;

public class Main {
    /**
     * matriz de characteres
     * iniciar com o X na primeira posição
     * devo ser capaz de mover o X
     * ao mover ele será movido uma vez para a direita
     * caso seja a ultima casa da linha, ele deve ser movido para a primeira casa da próxima coluna
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantidade de linhas: ");
        int quantidadeLinhas = scanner.nextInt();
        System.out.println("Quantidade de colunas: ");
        int quantidadeColunas = scanner.nextInt();

        System.out.println("Posição de linhas: ");
        int posicaoLinha = scanner.nextInt();
        System.out.println("Posição de colunas: ");
        int posicaoColuna = scanner.nextInt();

        Character[][] mat = new Character[quantidadeLinhas][quantidadeColunas];
        mat[posicaoLinha][posicaoColuna] = 'X';
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        moverEsquerda(mat);
        imprimir(mat);
        mover(mat);
        imprimir(mat);
        moverParaBaixo(mat);
        imprimir(mat);
        moverParaBaixo(mat);
        imprimir(mat);
        moverParaBaixo(mat);
        imprimir(mat);
        moverParaBaixo(mat);
        imprimir(mat);
        moverParaCima(mat);
        imprimir(mat);
        moverParaCima(mat);
        imprimir(mat);
        moverParaCima(mat);
        imprimir(mat);
        moverParaCima(mat);
        imprimir(mat);
        moverParaCima(mat);
        imprimir(mat);
        moverParaCima(mat);
        imprimir(mat);
    }

    public static void imprimir(Character[][] mat) {
        System.out.println();
        for (int indiceLinha = 0; indiceLinha < mat.length; indiceLinha++) {
            Character[] linha = mat[indiceLinha];
            System.out.print("[ ");
            for (int indiceColuna = 0; indiceColuna < mat[indiceLinha].length; indiceColuna++) {
                Character elemento = mat[indiceLinha][indiceColuna];
                if (elemento == null) {
                    System.out.print("_");
                } else {
                    System.out.print(elemento);
                }
                if (indiceColuna == linha.length - 1) {
                    System.out.println(" ]");
                } else {
                    System.out.print(" , ");
                }
            }
        }
    }

    public static void mover(Character[][] mat) {
        //mover sempre pra direita
        Character[] linha = mat[0];
        int[] posicao = encontrar(mat);
        int indiceLinha = posicao[0];
        int indiceColuna = posicao[1];

        if (indiceColuna == linha.length - 1) {
            // mover para baixo e para o começo quando chegar
            // na ultima posição da linha e mandar mover de novo para a direita
            moverParaBaixoEComeco(mat, indiceLinha);
        } else {
            mat[indiceLinha][indiceColuna + 1] = mat[indiceLinha][indiceColuna];
            mat[indiceLinha][indiceColuna] = null;
        }
    }

    public static void moverEsquerda(Character[][] mat) {
        Character[] linha = mat[0];
        int[] posicao = encontrar(mat);
        int indiceLinha = posicao[0];
        int indiceColuna = posicao[1];

        if (indiceColuna == 0) {
            // mover para cima e para o fim quando chegar
            // na primeira posição da linha e mandar mover de novo para a esquerda
            moverParaCimaEFim(mat, indiceLinha);
        } else {
            mat[indiceLinha][indiceColuna - 1] = mat[indiceLinha][indiceColuna];
            mat[indiceLinha][indiceColuna] = null;
        }
    }

    public static void moverParaCima(Character[][] mat) {
        Character[] linha = mat[0];
        int[] posicao = encontrar(mat);
        int indiceLinha = posicao[0];
        int indiceColuna = posicao[1];

        if (indiceLinha > 0) {
            mat[indiceLinha -1][indiceColuna] = mat[indiceLinha][indiceColuna];
            mat[indiceLinha][indiceColuna] = null;
        }
    }
    public static void moverParaBaixo(Character[][] mat) {
        Character[] linha = mat[0];
        int[] posicao = encontrar(mat);
        int indiceLinha = posicao[0];
        int indiceColuna = posicao[1];

        if (indiceLinha < mat.length-1) {
            mat[indiceLinha +1][indiceColuna] = mat[indiceLinha][indiceColuna];
            mat[indiceLinha][indiceColuna] = null;
        }
    }

    public static int[] encontrar(Character[][] mat) {
        int[] posicao = new int[2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != null) {
                    posicao[0] = i;
                    posicao[1] = j;
                }
            }
        }
        return posicao;
    }

    private static void moverParaBaixoEComeco(Character[][] mat, int indiceLinha) {
        int indiceColuna = mat[indiceLinha].length - 1;
        if (indiceLinha != mat.length - 1) {
            mat[indiceLinha + 1][0] = mat[indiceLinha][indiceColuna];
            mat[indiceLinha][indiceColuna] = null;
        }
    }

    private static void moverParaCimaEFim(Character[][] mat, int indiceLinha) {
        int indiceColuna = mat[indiceLinha].length - 1;
        if (indiceLinha != 0) {
            mat[indiceLinha - 1][indiceColuna] = mat[indiceLinha][0];
            mat[indiceLinha][0] = null;
        }
    }
}