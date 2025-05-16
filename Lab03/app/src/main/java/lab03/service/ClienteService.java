package lab03.service;

import lab03.model.Cliente;
import lab03.model.EventoShow;
import lab03.model.Ingresso;
import lab03.model.Organizadora;

/**
 * Serviço para compartilhar o mesmo cliente entre as telas do sistema
 */
public class ClienteService {
    private static ClienteService instance;
    private Cliente clienteAtual;
    
    private ClienteService() {
        // Criar cliente fictício padrão
        clienteAtual = criarClienteFicticio();
    }
    
    public static ClienteService getInstance() {
        if (instance == null) {
            instance = new ClienteService();
        }
        return instance;
    }
    
    public Cliente getClienteAtual() {
        return clienteAtual;
    }
    
    public void setClienteAtual(Cliente cliente) {
        this.clienteAtual = cliente;
    }
    
    private Cliente criarClienteFicticio() {
        Cliente cliente = new Cliente("Othavio Ayres", "othavio.ayres@email.com", 500.00);
        
        // Criar organizadora fictícia para os eventos
        Organizadora organizadora = new Organizadora("Eventos Brasil", 123456789, "Av. Paulista, 1000");
        
        // Criar eventos fictícios
        EventoShow evento1 = new EventoShow("Show de Rock Nacional", 150.00, organizadora, "2024-04-20", 5000, "Banda Nacional");
        EventoShow evento2 = new EventoShow("Festival de Cinema", 80.00, organizadora, "2024-05-15", 2000, "Festival Nacional");
        EventoShow evento3 = new EventoShow("Peça de Teatro", 120.00, organizadora, "2024-06-05", 300, "Grupo Teatral");
        EventoShow evento4 = new EventoShow("Exposição de Arte", 60.00, organizadora, "2024-04-30", 1000, "Expositor Nacional");
        
        // Adicionar ingressos ao cliente
        cliente.adicionarIngresso(new Ingresso(evento1, 150.00));
        cliente.adicionarIngresso(new Ingresso(evento2, 80.00));
        cliente.adicionarIngresso(new Ingresso(evento3, 120.00));
        cliente.adicionarIngresso(new Ingresso(evento4, 60.00));
        
        return cliente;
    }
} 