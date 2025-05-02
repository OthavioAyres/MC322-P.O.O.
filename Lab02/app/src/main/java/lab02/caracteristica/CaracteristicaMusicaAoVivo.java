package lab02.caracteristica;

public class CaracteristicaMusicaAoVivo extends CaracteristicaDeEvento {
    private String nomeArtista;
    private String generoMusical;

    public CaracteristicaMusicaAoVivo(String nomeArtista, String generoMusical) {
        super();
        this.nomeArtista = nomeArtista;
        this.generoMusical = generoMusical;
        
        // Adicionando as características ao mapa
        adicionarCaracteristica("Nome do Artista", nomeArtista);
        adicionarCaracteristica("Gênero Musical", generoMusical);
    }

    @Override
    public String descricao() {
        return "Nome do Artista: " + nomeArtista + "\n" +
               "Gênero Musical: " + generoMusical;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }
} 