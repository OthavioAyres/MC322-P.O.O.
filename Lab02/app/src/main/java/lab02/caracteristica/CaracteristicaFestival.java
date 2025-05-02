package lab02.caracteristica;

import java.util.List;

public class CaracteristicaFestival extends CaracteristicaDeEvento {
    private List<String> lineup;
    private int duracao;

    public CaracteristicaFestival(List<String> lineup, int duracao) {
        super();
        this.lineup = lineup;
        this.duracao = duracao;
        
        // Adicionando as características ao mapa
        adicionarCaracteristica("Lineup", lineup);
        adicionarCaracteristica("Duração (dias)", duracao);
    }

    public List<String> getLineup() {
        return lineup;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String descricao() {
        return "Lineup: " + lineup + "\n" +
               "Duração (dias): " + duracao;
    }
} 