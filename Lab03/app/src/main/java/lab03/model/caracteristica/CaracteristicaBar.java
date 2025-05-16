package lab03.model.caracteristica;

public class CaracteristicaBar extends CaracteristicaDeEvento {
    private String nomeBar;
    private String inicioHappyHour;
    private String duracaoHappyHour;

    public CaracteristicaBar(String nomeBar, String inicioHappyHour, String duracaoHappyHour) {
        super();
        this.nomeBar = nomeBar;
        this.inicioHappyHour = inicioHappyHour;
        this.duracaoHappyHour = duracaoHappyHour;
        
        // Adicionando as características ao mapa
        adicionarCaracteristica("Nome do Bar", nomeBar);
        adicionarCaracteristica("Início do Happy Hour", inicioHappyHour);
        adicionarCaracteristica("Duração do Happy Hour", duracaoHappyHour);
    }

    @Override
    public String descricao() {
        return "Nome doBar: " + nomeBar + "\n" +
               "Início do Happy Hour: " + inicioHappyHour + "\n" +
               "Duração do Happy Hour: " + duracaoHappyHour;
    }

    public String getNomeBar() {
        return nomeBar;
    }

    public String getInicioHappyHour() {
        return inicioHappyHour;
    }

    public String getDuracaoHappyHour() {
        return duracaoHappyHour;
    }
} 