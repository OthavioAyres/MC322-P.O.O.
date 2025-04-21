package lab02.filter;

import java.util.ArrayList;
import java.util.List;

import lab02.Evento;

public class EventoPorLocalFilter implements Filter {
    private String nomeLocal;
    
    public EventoPorLocalFilter(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }
    
    @Override
    public List<Evento> filter(List<Evento> eventos) {
        List<Evento> eventosFiltrados = new ArrayList<>();
        
        for (Evento evento : eventos) {
            if (evento.getLocal().getNome().toLowerCase().contains(nomeLocal.toLowerCase())) {
                eventosFiltrados.add(evento);
            }
        }
        
        return eventosFiltrados;
    }
} 