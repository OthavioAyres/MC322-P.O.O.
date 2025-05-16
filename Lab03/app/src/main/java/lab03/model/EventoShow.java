/*

 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03.model;

import lab03.model.caracteristica.CaracteristicaShow;

public class EventoShow extends Evento {
    private CaracteristicaShow caracteristicas;
    
    /**
    * Construtor da classe EventocShow
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param artista o artista do Evento
    * @param organizadora a organizadora do Evento
    */
    public EventoShow(String nome, double precoIngresso, Organizadora organizadora, String data, double quantidadeParticipantes, String artista) {
        super(nome, precoIngresso, organizadora, data, quantidadeParticipantes);
        this.caracteristicas = new CaracteristicaShow(artista);
    }
    
    /**
    * Retorna o preço do Ingresso do Evento
    * @return o preço do Ingresso do Evento
    */
    public double getPrecoIngresso() {
        return this.precoIngresso;
    }

    public String getArtista() {
        return caracteristicas.getArtista();
    }

    public String getDescricaoCaracteristicas() {
        return caracteristicas.descricao();
    }
}
