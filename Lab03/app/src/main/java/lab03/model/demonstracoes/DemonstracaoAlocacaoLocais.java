package lab03.model.demonstracoes;

import lab03.model.exceptions.CapacidadeInsuficienteException;
import lab03.model.exceptions.LocalIndisponivelException;
import lab03.model.EventoShow;
import lab03.model.Local;
import lab03.model.Organizadora;

/**
 * Classe para demonstrar a alocação de locais com tratamento de exceções
 */
public class DemonstracaoAlocacaoLocais {

    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DE ALOCAÇÃO DE LOCAIS ===\n");
        
        // Criando locais
        Local localTeatro = new Local("Teatro Pequeno", 1);
        Local localEstadio = new Local("Estádio Municipal", 10000);
        
        // Criando organizadora
        Organizadora organizadora = new Organizadora("Eventos Teste", 987654321, "Rua Teste, 123");
        
        // Tentando alocar eventos em locais com capacidade insuficiente
        try {
            // Criando evento com muitos participantes para o teatro pequeno
            System.out.println("1. Tentando alocar um evento grande em um local pequeno:");
            EventoShow showGrande = organizadora.criarEvento(
                "Show Grande",
                localTeatro,
                200.0,
                "01/05/2024",
                5,
                "Banda Famosa"
            );
            
        } catch (CapacidadeInsuficienteException e) {
            System.out.println("   Erro ao alocar local: " + e.getMessage());
        } catch (LocalIndisponivelException e) {
            System.out.println("   Erro ao alocar local: " + e.getMessage());
        }
        
        // Tentando alocar dois eventos no mesmo local
        try {
            // Criando dois eventos para o mesmo local
            System.out.println("\n2. Tentando alocar dois eventos no mesmo local:");
            EventoShow show1 = organizadora.criarEvento(
                "Show 1",
                localEstadio,
                100.0,
                "10/05/2024",
                5,
                "Artista 1"
            );
            
            System.out.println("   Evento '" + show1.getNome() + "' alocado com sucesso no local '" + localEstadio.getNome() + "'");
            
            EventoShow show2 = organizadora.criarEvento(
                "Show 2",
                localEstadio,
                120.0,
                "11/05/2024",
                5,
                "Artista 2"
            );
            
            System.out.println("   Evento '" + show2.getNome() + "' alocado com sucesso no local '" + localEstadio.getNome() + "'");
            
        } catch (CapacidadeInsuficienteException e) {
            System.out.println("   Erro ao alocar local: " + e.getMessage());
        } catch (LocalIndisponivelException e) {
            System.out.println("   Erro ao alocar local: " + e.getMessage());
        }
    }
} 