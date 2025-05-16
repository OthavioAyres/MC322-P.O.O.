package lab03.model.demonstracoes;

import java.util.ArrayList;
import java.util.List;

import lab03.model.exceptions.CapacidadeInsuficienteException;
import lab03.model.exceptions.LocalIndisponivelException;
import lab03.model.Cliente;
import lab03.model.EventoFestival;
import lab03.model.EventoShow;
import lab03.model.Local;
import lab03.model.Organizadora;
import lab03.model.exceptions.IngressoEsgotadoException;
import lab03.model.exceptions.EventoNaoEncontradoException;
import lab03.model.exceptions.IngressoNaoEncontradoException;
import lab03.model.exceptions.CancelamentoNaoPermitidoException;

/**
 * Classe para demonstrar o cancelamento de ingressos com tratamento de exceções
 */
public class DemonstracaoCancelamentoIngressos {

    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DE CANCELAMENTO DE INGRESSOS ===\n");
        
        // Criando clientes
        Cliente cliente1 = new Cliente("Othavio", "tata@email.com");
        Cliente cliente2 = new Cliente("Henrique", "heheque@email.com");
        
        // Criando organizadora e local para testes
        Organizadora organizadora = new Organizadora("Eventos Cancelamento", 111222333, "pindamonhangaba");
        Local local = new Local("Arena", 1000);
        Local local2 = new Local("Arena_gratuito", 1000);
        try {
            // Criando evento para teste de cancelamento
            System.out.println("1. Comprando e cancelando ingresso pago:");
            EventoShow show = organizadora.criarEvento(
                "Show Cancelável",
                local,
                150.0,
                "30/05/2024",
                5,
                "Artista Teste"
            );

            // Vendendo ingresso para cliente1
            show.venderIngresso(cliente1);
            System.out.println("   Ingresso vendido para " + cliente1.getNome());
            
            // Cancelando o ingresso (deve funcionar)
            cliente1.cancelarIngresso(show);
            System.out.println("   Ingresso cancelado com sucesso para " + cliente1.getNome());
            
            // Tentando cancelar novamente (deve falhar - ingresso não encontrado)
            System.out.println("\n2. Tentando cancelar um ingresso que já foi cancelado:");
            cliente1.cancelarIngresso(show);
            
        } catch (IngressoNaoEncontradoException e) {
            System.out.println("   Erro ao cancelar ingresso: " + e.getMessage());
        } catch (CancelamentoNaoPermitidoException e) {
            System.out.println("   Erro ao cancelar ingresso: " + e.getMessage());
        } catch (IngressoEsgotadoException | EventoNaoEncontradoException | CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("   Erro: " + e.getMessage());
        }
        
        // Testando cancelamento não permitido
        try {
            // Criando evento gratuito
            System.out.println("\n3. Tentando cancelar um ingresso gratuito:");
            EventoFestival eventoGratuito = criarEventoGratuito(organizadora, local2);
            
            // Vendendo ingresso gratuito para cliente2
            eventoGratuito.venderIngresso(cliente2);
            System.out.println("   Ingresso gratuito vendido para " + cliente2.getNome());
            
            // Tentando cancelar ingresso gratuito (deve falhar - cancelamento não permitido)
            cliente2.cancelarIngresso(eventoGratuito);
            
        } catch (IngressoNaoEncontradoException e) {
            System.out.println("   Erro ao cancelar ingresso: " + e.getMessage());
        } catch (CancelamentoNaoPermitidoException e) {
            System.out.println("   Erro ao cancelar ingresso: " + e.getMessage());
        } catch (IngressoEsgotadoException | EventoNaoEncontradoException | CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("   Erro: " + e.getMessage());
        }
    }
    
    /**
     * Cria um evento gratuito para testes
     */
    private static EventoFestival criarEventoGratuito(Organizadora organizadora, Local local) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        List<String> lineup = new ArrayList<>();
        lineup.add("Artista 1");
        lineup.add("Artista 2");
        
        EventoFestival festival = organizadora.criarEvento(
            "Festival Gratuito",
            local,
            0.0,  // Preço zero
            "01/06/2024",
            5,
            lineup,
            1
        );
        
        return festival;
    }
} 