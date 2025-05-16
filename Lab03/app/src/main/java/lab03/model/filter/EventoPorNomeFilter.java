package lab03.model.filter;

import java.util.ArrayList;
import java.util.List;

import lab03.model.Evento;

public class EventoPorNomeFilter implements Filter {
    private String nome;
    
    public EventoPorNomeFilter(String nome) {
        this.nome = nome;
    }
    
    @Override
    public List<Evento> filter(List<Evento> eventos) {
        List<Evento> eventosFiltrados = new ArrayList<>();
        
        for (Evento evento : eventos) {
            if (evento.getNome().toLowerCase().contains(nome.toLowerCase())) {
                eventosFiltrados.add(evento);
            }
        }
        
        return eventosFiltrados;
    }
} 