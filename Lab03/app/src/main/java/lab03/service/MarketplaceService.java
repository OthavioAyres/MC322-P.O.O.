package lab03.service;

import lab03.model.*;

/**
 * Serviço singleton para gerenciar o marketplace globalmente na aplicação
 */
public class MarketplaceService {
    private static MarketplaceService instance;
    private Marketplace marketplace;
    
    private MarketplaceService() {
        // Inicializa o marketplace vazio com comissão padrão de 10%
        marketplace = new Marketplace("Marketplace de Ingressos", 10.0);
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
} 