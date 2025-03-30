package lab3ex1;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class SistemaFilmes {
    private List<Filme> filmes;
    private Set<String> titulos;

    public SistemaFilmes() {
        this.filmes = new ArrayList<>();
        this.titulos = new HashSet<>();
    }

    /**
     * Adiciona um filme ao sistema, desde que o seu titulo nao esteja
     * ja cadastrado.
     *
     * @param filme o filme a ser adicionado
     * @return true se o filme foi adicionado, false caso contrario
     */
    public boolean addTitulo(Filme filme) {
        if (this.titulos.contains(filme.getTitulo())) {
            return false;
        }
        this.filmes.add(filme);
        this.titulos.add(filme.getTitulo());
        return true;
    }

    /**
     * Retorna a mediana das notas dos filmes do sistema, ordenadas em
     * ordem crescente. Se o sistema estiver vazio, retorna -1.
     *
     * @return a mediana das notas dos filmes
     */
    public double medianaNotas() {
        if (this.filmes.size() == 0) {
            return -1;
        }
        this.filmes.sort(new NotaComparison());
        int n = this.filmes.size();
        if (n % 2 == 0) {
            return (this.filmes.get(n / 2 - 1).getNota() + this.filmes.get(n / 2).getNota()) / 2;
        }
        return this.filmes.get(n / 2).getNota();
    }


}

/**
 * Classe que compara dois filmes pela nota.
 */
class NotaComparison implements java.util.Comparator<Filme> {
    @Override
    public int compare(Filme filme_a, Filme filme_b) {
        return Double.compare(filme_a.getNota(), filme_b.getNota());
    }
}