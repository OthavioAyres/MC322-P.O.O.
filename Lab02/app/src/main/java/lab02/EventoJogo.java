/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */


package lab02;

import java.util.List;
import lab02.caracteristica.CaracteristicaJogo;

public class EventoJogo extends Evento {
    private CaracteristicaJogo caracteristicas;
    /**
    * Construtor da classe EventoEsporte
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param organizadora a organizadora do Evento
    * @param data a data do Evento
    * @param quantidadeParticipantes a quantidade de participantes do Evento
    * @param times a lista com os nomes dos times que se enfrentam no Evento
    */
    public EventoJogo(String nome, double precoIngresso, Organizadora organizadora, String data, double quantidadeParticipantes, List<String> times) {
        super(nome, precoIngresso, organizadora, data, quantidadeParticipantes);
        this.caracteristicas = new CaracteristicaJogo(times);
    }

    /**
     * Retorna a lista com os nomes dos times que se enfrentam no Evento
     * @return a lista com os nomes dos times do Evento
     */
    public List<String> getTimes() {
        return caracteristicas.getTimes();
    }


    public String getDescricaoCaracteristicas() {
        return caracteristicas.descricao();
    }
}
