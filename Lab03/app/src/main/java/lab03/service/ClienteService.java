package lab03.service;

import lab03.model.Cliente;
import lab03.model.EventoShow;
import lab03.model.Ingresso;
import lab03.model.Organizadora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Serviço para compartilhar o mesmo cliente entre as telas do sistema
 */
public class ClienteService {
    private static ClienteService instance;
    private Cliente clienteAtual;
    private Map<String, Cliente> clientesRegistrados;
    
    private ClienteService() {
        // Inicializa a lista de clientes registrados
        clientesRegistrados = new HashMap<>();
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
    
    /**
     * Registra um cliente no sistema
     * @param cliente Cliente a ser registrado
     */
    public void registrarCliente(Cliente cliente) {
        // Verificar se o cliente já está registrado
        if (!clientesRegistrados.containsKey(cliente.getEnderecoEmail())) {
            // Se for um novo cliente, adicionar ingressos iniciais de exemplo
            adicionarIngressosIniciais(cliente);
        }
        
        // Registrar ou atualizar o cliente no mapa
        clientesRegistrados.put(cliente.getEnderecoEmail(), cliente);
    }
    
    /**
     * Busca um cliente pelo email
     * @param email Email do cliente a ser buscado
     * @return O cliente encontrado ou null se não encontrado
     */
    public Cliente buscarClientePorEmail(String email) {
        return clientesRegistrados.get(email);
    }
    
    /**
     * Retorna a lista de todos os clientes registrados
     * @return Lista de clientes
     */
    public List<Cliente> getClientesRegistrados() {
        return new ArrayList<>(clientesRegistrados.values());
    }
    
    /**
     * Adiciona ingressos de exemplo para um novo cliente
     * @param cliente Cliente que receberá os ingressos
     */
    private void adicionarIngressosIniciais(Cliente cliente) {
        // Criar organizadora fictícia para os eventos
        Organizadora organizadora = new Organizadora("Eventos Brasil", 123456789, "Av. Paulista, 1000");
        
        
        // Criar eventos fictícios específicos para este cliente
        EventoShow evento1 = new EventoShow("Show de Rock" , 150.00, organizadora, "2024-04-20", 5000, "Banda Nacional");
        EventoShow evento2 = new EventoShow("Festival de Cinema" , 80.00, organizadora, "2024-05-15", 2000, "Festival Nacional");

        // Adicionar ingressos ao cliente
        cliente.adicionarIngresso(new Ingresso(evento1, 150.00));
    }
} 