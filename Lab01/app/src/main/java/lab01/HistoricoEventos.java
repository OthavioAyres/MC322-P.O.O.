package lab01;

import java.util.ArrayList;
import java.util.List;

public class HistoricoEventos {
    private List<Evento> eventos = new ArrayList<Evento>();

    /**
     * Adiciona um novo evento ao histórico de eventos.
     * @param new_evento o evento a ser adicionado.
     */
    public void adicionarEvento(Evento new_evento){
        eventos.add(new_evento);
    }
    
    /**
     * Retorna a lista de todos os eventos no histórico.
     * @return a lista de eventos.
     */
    public List<Evento> getEventos() {
        return eventos;
    }

    /**
     * Busca eventos no histórico com base no tipo de evento.
     * @param tipo a classe do tipo de evento a ser buscado.
     * @return uma lista de eventos que correspondem ao tipo especificado.
     */
    public List<Evento> buscarEventosPorTipo(Class<? extends Evento> tipo) {
        List<Evento> eventos_encontrados = new ArrayList<>();
        for (Evento evento_instancia : eventos) {
            if (tipo.isInstance(evento_instancia)) {
                eventos_encontrados.add(evento_instancia);
            }
        }
        return eventos_encontrados;
    }

    /**
     * Busca eventos no histórico com base no nome do local.
     * @param local_nome o nome do local a ser buscado.
     * @return uma lista de eventos realizados no local especificado.
     */
    public List<Evento> buscarEventosPorLocalNome(String local_nome) {
        List<Evento> eventos_encontrados = new ArrayList<>();
        for (Evento evento_instancia : eventos) {
            if (evento_instancia.getLocal().getNome().equals(local_nome)) {
                eventos_encontrados.add(evento_instancia);
            }
        }
        return eventos_encontrados;
    }

    /**
     * Busca eventos no histórico com base em um filtro personalizado.
     * @param filtro o filtro a ser aplicado aos eventos.
     * @return uma lista de eventos que atendem ao filtro especificado.
     */
    public List<Evento> BuscarEventos(FiltroEvento filtro){
        List<Evento> eventos_filtrados = new ArrayList<>();
        for (Evento evento_instancia : eventos) {
            if (filtro.filtrar(evento_instancia)) {
                eventos_filtrados.add(evento_instancia);
            }
        }
        return eventos_filtrados;
    }
}
