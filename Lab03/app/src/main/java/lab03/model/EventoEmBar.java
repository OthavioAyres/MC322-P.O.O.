package lab03.model;

import lab03.model.caracteristica.CaracteristicaBar;

public class EventoEmBar extends Evento {
    private CaracteristicaBar caracteristicas;

    public EventoEmBar(String nome, double precoIngresso, Organizadora organizadora, String data, double quantidadeParticipantes, 
                      String nomeBar, String inicioHappyHour, String duracaoHappyHour) {
        super(nome, precoIngresso, organizadora, data, quantidadeParticipantes);
        this.caracteristicas = new CaracteristicaBar(nomeBar, inicioHappyHour, duracaoHappyHour);
    }

    public String getNomeBar() {
        return caracteristicas.getNomeBar();
    }

    public String getInicioHappyHour() {
        return caracteristicas.getInicioHappyHour();
    }

    public String getDuracaoHappyHour() {
        return caracteristicas.getDuracaoHappyHour();
    }

    /**
     * Retorna a descrição das características do bar
     * @return string com a descrição das características
     */
    public String getDescricaoCaracteristicas() {
        return caracteristicas.descricao();
    }

    /**
     * Retorna o valor de uma característica específica do bar
     * @param nome nome da característica
     * @return valor da característica ou null se não existir
     */
    public Object getCaracteristicaBar(String nome) {
        return caracteristicas.getCaracteristica(nome);
    }
} 