package lab02.filter;

import java.util.ArrayList;
import java.util.List;

import lab02.Evento;
import lab02.Organizadora;

public class EventoPorOrganizadoraFilter implements Filter {
    private String nomeOrganizadora;
    
    public EventoPorOrganizadoraFilter(String nomeOrganizadora) {
        this.nomeOrganizadora = nomeOrganizadora;
    }
    
    @Override
    public List<Evento> filter(List<Evento> eventos) {
        List<Evento> eventosFiltrados = new ArrayList<>();
        
        for (Evento evento : eventos) {
            Organizadora organizadora = evento.getOrganizadora();
            if (organizadora != null && 
                organizadora.getNome().toLowerCase().contains(nomeOrganizadora.toLowerCase())) {
                eventosFiltrados.add(evento);
            }
        }
        
        return eventosFiltrados;
    }
} 