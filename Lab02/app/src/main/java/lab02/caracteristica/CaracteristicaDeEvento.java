package lab02.caracteristica;

import java.util.HashMap;
import java.util.Map;

public abstract class CaracteristicaDeEvento {
    protected Map<String, Object> caracteristicas;

    public CaracteristicaDeEvento() {
        this.caracteristicas = new HashMap<>();
    }

    /**
     * Adiciona uma característica ao evento
     * @param nome nome da característica
     * @param valor valor da característica
     */
    public void adicionarCaracteristica(String nome, Object valor) {
        caracteristicas.put(nome, valor);
    }

    /**
     * Retorna uma descrição das características do evento
     * @return string com a descrição das características
     */
    public abstract String descricao();

    /**
     * Retorna o valor de uma característica específica
     * @param nome nome da característica
     * @return valor da característica ou null se não existir
     */
    public Object getCaracteristica(String nome) {
        return caracteristicas.get(nome);
    }
} 