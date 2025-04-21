/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */


package lab02;

import java.util.List;

public class EventoJogo extends Evento {
        
    private List<String> times;
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
        this.times = times;
    }

    /**
     * Retorna a lista com os nomes dos times que se enfrentam no Evento
     * @return a lista com os nomes dos times do Evento
     */
    public List<String> getTimes() {
        return times;
    }

    /**
     * Retorna uma string contendo a descri o do Evento, com seu nome, times, local e data
     * @return uma string com a descri o do Evento
     */
    @Override
    public String descricao() {
        return "Esporte: " + this.nome + " - Times: " + this.times + " - Local: " + this.local;
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
