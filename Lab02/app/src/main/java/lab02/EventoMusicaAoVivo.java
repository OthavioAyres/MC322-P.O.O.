package lab02;

import lab02.caracteristica.CaracteristicaMusicaAoVivo;

public class EventoMusicaAoVivo extends Evento {
    private CaracteristicaMusicaAoVivo caracteristicas;

    public EventoMusicaAoVivo(String nome, double precoIngresso, Organizadora organizadora, String data, double quantidadeParticipantes,
                             String nomeArtista, String generoMusical) {
        super(nome, precoIngresso, organizadora, data, quantidadeParticipantes);
        this.caracteristicas = new CaracteristicaMusicaAoVivo(nomeArtista, generoMusical);
    }

    public String getNomeArtista() {
        return caracteristicas.getNomeArtista();
    }

    public String getGeneroMusical() {
        return caracteristicas.getGeneroMusical();
    }

    /**
     * Retorna a descrição das características do evento de música ao vivo
     * @return string com a descrição das características
     */
    public String getDescricaoCaracteristicas() {
        return caracteristicas.descricao();
    }

    /**
     * Retorna o valor de uma característica específica do evento de música ao vivo
     * @param nome nome da característica
     * @return valor da característica ou null se não existir
     */
    public Object getCaracteristicaMusica(String nome) {
        return caracteristicas.getCaracteristica(nome);
    }
} 