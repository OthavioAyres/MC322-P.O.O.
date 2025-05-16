package lab03.model.demonstracoes;

import lab03.model.exceptions.CapacidadeInsuficienteException;
import lab03.model.exceptions.LocalIndisponivelException;
import lab03.model.Cliente;
import lab03.model.EventoShow;
import lab03.model.Local;
import lab03.model.Organizadora;
import lab03.model.exceptions.IngressoEsgotadoException;
import lab03.model.exceptions.EventoNaoEncontradoException;

/**
 * Classe para demonstrar a venda de ingressos com tratamento de exceções
 */
public class DemonstracaoVendaIngressos {

    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DE VENDA DE INGRESSOS ===\n");
        
        // Criando clientes
        Cliente cliente1 = new Cliente("Othavio", "tata@email.com");
        Cliente cliente2 = new Cliente("Henrique", "heheque@email.com");
        
        // Criando organizadora
        Organizadora organizadora = new Organizadora("Eventos Inc.", 123456789, "Rua dos Eventos, 123");
        
        // Criando local com capacidade limitada
        Local localPequeno = new Local("Sala de Show", 2);
        
        try {
            // Criando evento com capacidade muito limitada
            System.out.println("1. Criando evento com capacidade limitada (2 ingressos):");
            EventoShow showPequeno = organizadora.criarEvento(
                "Show Exclusivo",
                localPequeno,
                500.0,
                "20/05/2024",
                2,
                "Artista Exclusivo"
            );
            
            System.out.println("   Evento '" + showPequeno.getNome() + "' criado com sucesso!");
            
            // Vendendo ingressos até esgotar
            System.out.println("\n2. Tentando vender ingressos para o evento:");
            
            // Venda para cliente1 (deve funcionar)
            showPequeno.venderIngresso(cliente1);
            System.out.println("   Ingresso vendido para " + cliente1.getNome());
            
            // Venda para cliente2 (deve funcionar)
            showPequeno.venderIngresso(cliente2);
            System.out.println("   Ingresso vendido para " + cliente2.getNome());
            
            // Tentando vender mais um ingresso (deve falhar)
            System.out.println("\n3. Tentando vender ingresso quando não há mais disponíveis:");
            Cliente cliente3 = new Cliente("Carlos", "carlos@email.com");
            showPequeno.venderIngresso(cliente3);
            System.out.println("   Ingresso vendido para " + cliente3.getNome());
            
        } catch (IngressoEsgotadoException e) {
            System.out.println("   Erro ao vender ingresso: " + e.getMessage());
        } catch (EventoNaoEncontradoException e) {
            System.out.println("   Erro ao vender ingresso: " + e.getMessage());
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("   Erro ao criar evento: " + e.getMessage());
        }
    }
} 