package lab02.filter;

import java.util.ArrayList;
import java.util.List;

import lab02.Evento;

public class EventoPorDataFilter implements Filter {
    private String data;
    
    public EventoPorDataFilter(String data) {
        this.data = data;
    }
    
    @Override
    public List<Evento> filter(List<Evento> eventos) {
        List<Evento> eventosFiltrados = new ArrayList<>();
        
        for (Evento evento : eventos) {
            if (evento.getData().equals(data)) {
                eventosFiltrados.add(evento);
            }
        }
        
        return eventosFiltrados;
    }
} 