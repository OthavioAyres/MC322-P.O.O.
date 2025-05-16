package lab03.model.caracteristica;

import java.util.List;

public class CaracteristicaJogo extends CaracteristicaDeEvento {
    private List<String> times;

    public CaracteristicaJogo(List<String> times) {
        super();
        this.times = times;
        
        // Adicionando as características ao mapa
        adicionarCaracteristica("Times", times);
    }

    public List<String> getTimes() {
        return times;
    }

    @Override
    public String descricao() {
        return "Times: " + times;
    }
} 