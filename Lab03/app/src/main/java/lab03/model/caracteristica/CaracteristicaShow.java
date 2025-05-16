package lab03.model.caracteristica;

public class CaracteristicaShow extends CaracteristicaDeEvento {
    private String artista;

    public CaracteristicaShow(String artista) {
        super();
        this.artista = artista;
        
        // Adicionando as características ao mapa
        adicionarCaracteristica("Artista", artista);
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String descricao() {
        return "Artista: " + artista;
    }
} 