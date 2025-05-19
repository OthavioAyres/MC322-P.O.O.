package lab03.service;

import lab03.model.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Serviço singleton para gerenciar os eventos disponíveis na aplicação
 */
public class EventoService {
    private static EventoService instance;
    private List<Evento> eventosDisponiveis;
    
    private EventoService() {
        // Inicializa a lista de eventos disponíveis
        inicializarEventosDisponiveis();
    }
    
    public static EventoService getInstance() {
        if (instance == null) {
            instance = new EventoService();
        }
        return instance;
    }
    
    public List<Evento> getEventosDisponiveis() {
        return eventosDisponiveis;
    }
    
    private void inicializarEventosDisponiveis() {
        eventosDisponiveis = new ArrayList<>();
        
        // Criar organizadora fictícia
        Organizadora organizadora = new Organizadora("Eventos Brasil", 123456789, "Av. Paulista, 1000");
        
        // Criar eventos fictícios
        EventoShow evento1 = new EventoShow("Show de Rock", 150.00, organizadora, "2024-06-15", 3000, "Banda Rock");
        EventoShow evento2 = new EventoShow("Festival de Música", 200.00, organizadora, "2024-07-20", 5000, "Vários Artistas");
        EventoShow evento3 = new EventoShow("Show de Jazz", 180.00, organizadora, "2024-08-10", 2000, "Jazz Band");
        EventoShow evento4 = new EventoShow("Espetáculo de Dança", 120.00, organizadora, "2024-09-05", 1500, "Companhia de Dança");
        EventoShow evento5 = new EventoShow("Show Internacional", 300.00, organizadora, "2024-10-01", 4000, "Artista Internacional");
        
        // Adicionar eventos à lista
        eventosDisponiveis.add(evento1);
        eventosDisponiveis.add(evento2);
        eventosDisponiveis.add(evento3);
        eventosDisponiveis.add(evento4);
        eventosDisponiveis.add(evento5);
    }
} 