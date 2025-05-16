package lab03.model.filter;

import java.util.ArrayList;
import java.util.List;

import lab03.model.Evento;

/**
 * Filtro composto que aplica múltiplos filtros sequencialmente.
 * Permite combinar vários critérios de filtragem em uma única operação.
 */
public class AndFilter implements Filter {
    private List<Filter> filtros;
    
    /**
     * Construtor que recebe uma lista de filtros para compor o filtro composto
     * @param filtros a lista de filtros a serem aplicados sequencialmente
     */
    public AndFilter(List<Filter> filtros) {
        this.filtros = filtros;
    }
    
    /**
     * Aplica todos os filtros sequencialmente na lista de eventos
     * @param eventos a lista de eventos a ser filtrada
     * @return uma nova lista contendo apenas os eventos que passaram por todos os filtros
     */
    @Override
    public List<Evento> filter(List<Evento> eventos) {
        if (filtros == null || filtros.isEmpty()) {
            return new ArrayList<>(eventos); // Retorna uma cópia da lista original se não houver filtros
        }
        
        List<Evento> resultado = new ArrayList<>(eventos);
        
        for (Filter filtro : filtros) {
            resultado = filtro.filter(resultado);
        }
        
        return resultado;
    }
} 