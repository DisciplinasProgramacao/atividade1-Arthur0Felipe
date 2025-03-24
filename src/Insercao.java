import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Insercao<T extends Comparable<T>> implements IOrdenador<T> {

    private long comparacoes;
    private long movimentacoes;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    @Override
    public T[] ordenar(T[] dados) {
        T[] copiaDados = Arrays.copyOf(dados, dados.length);
        comparacoes = movimentacoes = 0;
        int tamanho = copiaDados.length;
        inicio = LocalDateTime.now();

        for (int posicaoRef = 1; posicaoRef <= tamanho - 1; posicaoRef++) {
            T valor = copiaDados[posicaoRef];
            int j = posicaoRef - 1;
            comparacoes++;
            while (j >= 0 && valor.compareTo(copiaDados[j]) < 0) {
                j--;
                comparacoes++;
            }
            copiaDados(j + 1, posicaoRef, copiaDados);
            copiaDados[j + 1] = valor;
        }

        fim = LocalDateTime.now();
        return copiaDados;
    }

    private void copiaDados(int inicio, int fim, T[] vetor) {
        for (int i = fim; i > inicio; i--) {
            movimentacoes++;
            vetor[i] = vetor[i - 1];
        }
    }

    @Override
    public long getComparacoes() {
        return comparacoes;
    }

    @Override
    public long getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public double getTempoOrdenacao() {
        return Duration.between(inicio, fim).toMillis();
    }

}
