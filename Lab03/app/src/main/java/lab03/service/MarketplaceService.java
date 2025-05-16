package lab03.service;

import lab03.model.*;

/**
 * Serviço singleton para gerenciar o marketplace globalmente na aplicação
 */
public class MarketplaceService {
    private static MarketplaceService instance;
    private Marketplace marketplace;
    
    private MarketplaceService() {
        // Inicializa o marketplace com dados fictícios
        inicializarMarketplaceFicticio();
    }
    
    public static MarketplaceService getInstance() {
        if (instance == null) {
            instance = new MarketplaceService();
        }
        return instance;
    }
    
    public Marketplace getMarketplace() {
        return marketplace;
    }
    
    private void inicializarMarketplaceFicticio() {
        marketplace = new Marketplace("Marketplace de Ingressos", 10.0);
        
        // Criar organizadora fictícia
        Organizadora organizadora = new Organizadora("Eventos Brasil", 123456789, "Av. Paulista, 1000");
        
        // Criar outros clientes para serem os vendedores
        Cliente vendedor1 = new Cliente("Maria Santos", "maria.santos@email.com");
        Cliente vendedor2 = new Cliente("João Oliveira", "joao.oliveira@email.com");
        Cliente vendedor3 = new Cliente("Ana Silva", "ana.silva@email.com");
        
        // Criar eventos fictícios
        EventoShow evento1 = new EventoShow("Show de Jazz", 200.00, organizadora, "2024-05-10", 3000, "Jazz Band");
        EventoShow evento2 = new EventoShow("Festival de Verão", 180.00, organizadora, "2024-06-12", 8000, "Vários Artistas");
        EventoShow evento3 = new EventoShow("Exposição de Fotografias", 50.00, organizadora, "2024-04-25", 500, "Fotógrafos Renomados");
        EventoShow evento4 = new EventoShow("Espetáculo de Dança", 120.00, organizadora, "2024-07-08", 1200, "Companhia Nacional");
        EventoShow evento5 = new EventoShow("Show Internacional", 350.00, organizadora, "2024-08-15", 12000, "Artista Internacional");
        
        // Criar ingressos para esses eventos
        Ingresso ingresso1 = new Ingresso(evento1, 200.00);
        Ingresso ingresso2 = new Ingresso(evento2, 180.00);
        Ingresso ingresso3 = new Ingresso(evento3, 50.00);
        Ingresso ingresso4 = new Ingresso(evento4, 120.00);
        Ingresso ingresso5 = new Ingresso(evento5, 350.00);
        
        // Adicionar ofertas ao marketplace
        marketplace.receberOferta(ingresso1, 190.00, vendedor1);  // Desconto pequeno
        marketplace.receberOferta(ingresso2, 160.00, vendedor2);  // Bom desconto
        marketplace.receberOferta(ingresso3, 45.00, vendedor3);   // Pequeno desconto
        marketplace.receberOferta(ingresso4, 100.00, vendedor1);  // Bom desconto
        marketplace.receberOferta(ingresso5, 300.00, vendedor2);  // Bom desconto
    }
} 