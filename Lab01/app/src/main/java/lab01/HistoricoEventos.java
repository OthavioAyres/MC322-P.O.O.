package lab01;

import java.util.ArrayList;
import java.util.List;

public class HistoricoEventos {
    private List<Evento> eventos = new ArrayList<Evento>();

    public void adicionarEvento(Evento new_evento){
        eventos.add(new_evento);
    }
    
    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Evento> buscarEventosPorTipo(Class<? extends Evento> tipo) {
        List<Evento> eventos_encontrados = new ArrayList<>();
        for (Evento evento_instancia : eventos) {
            if (tipo.isInstance(evento_instancia)) {
                eventos_encontrados.add(evento_instancia);
            }
        }
        return eventos_encontrados;
    }

    public List<Evento> buscarEventosPorLocalNome(String local_nome) {
        List<Evento> eventos_encontrados = new ArrayList<>();
        for (Evento evento_instancia : eventos) {
            if (evento_instancia.getLocal().getNome().equals(local_nome)) {
                eventos_encontrados.add(evento_instancia);
            }
        }
        return eventos_encontrados;
    }

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
