import java.util.Random;

public class AppOrdenacao {
    static Random aleatorio = new Random(42);

    static Integer[] gerarVetor(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(i, i + 3);
        }
        return vetor;
    }

    public static void main(String[] args) {
        Integer[] vetor = gerarVetor(50000);
        IOrdenador<Integer> ordenador = new Bubblesort<Integer>();
        Integer[] vetorOrdenado = ordenador.ordenar(vetor);

        System.out.println("Bolha");
        System.out.println(vetor.length);
        System.out.println(ordenador.getComparacoes());
        System.out.println(ordenador.getMovimentacoes());
        System.out.println(ordenador.getTempoOrdenacao());

        System.out.println("Inserção");
        ordenador = new Insercao<Integer>();
        ordenador.ordenar(vetor);
        System.out.println(vetor.length);
        System.out.println(ordenador.getComparacoes());
        System.out.println(ordenador.getMovimentacoes());
        System.out.println(ordenador.getTempoOrdenacao());
    }
}
