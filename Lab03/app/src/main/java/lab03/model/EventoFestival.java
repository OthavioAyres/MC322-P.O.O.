/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03.model;

import java.util.List;
import lab03.model.caracteristica.CaracteristicaFestival;

public class EventoFestival extends Evento {
    private CaracteristicaFestival caracteristicas;

    /**
    * Construtor da classe EventoFestival
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param data a data do Festival
    * @param lineup a lista de artistas do Festival
    * @param duracao a duração do Festival em dias
    */
    public EventoFestival(String nome, double precoIngresso, Organizadora organizadora, String data, double quantidadeParticipantes, List<String> lineup, int duracao) {
        super(nome, precoIngresso, organizadora, data, quantidadeParticipantes);
        this.caracteristicas = new CaracteristicaFestival(lineup, duracao);
    }

    /**
    * Retorna a lista com os nomes dos artistas que se apresentarão no Festival
    * @return a lista com os nomes dos artistas do Festival
    */
    public List<String> getLineup() {
        return caracteristicas.getLineup();
    }
    
    /**
    * Retorna a dura o do Festival em dias
    * @return a dura o do Festival
    */
    public int getDuracao() {
        return caracteristicas.getDuracao();
    }

    /**
     * Retorna uma string contendo a descri o do Festival, com seu nome, lineup, local e dura o
     * @return uma string com a descri o do Festival
     */
    public String getDescricaoCaracteristicas() {
        return caracteristicas.descricao();
    }

    /**
    * Retorna o preço do Ingresso do Evento
    * @return o preço do Ingresso do Evento
    */
    @Override
    public double getPrecoIngresso() {
        return this.precoIngresso;
    }
}
