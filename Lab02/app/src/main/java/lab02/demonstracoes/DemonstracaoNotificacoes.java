package lab02.demonstracoes;

import lab02.exceptions.CapacidadeInsuficienteException;
import lab02.exceptions.LocalIndisponivelException;
import lab02.exceptions.IngressoNaoEncontradoException;
import lab02.exceptions.CancelamentoNaoPermitidoException;
import lab02.exceptions.IngressoEsgotadoException;
import lab02.exceptions.EventoNaoEncontradoException;
import lab02.Organizadora;
import lab02.Local;
import lab02.EventoShow;
import lab02.Cliente;

/**
 * Classe para demonstrar o uso das notificações por email
 */
public class DemonstracaoNotificacoes {

    public static void main(String[] args) {
        try {
            // Criando organizadora
            Organizadora organizadora = new Organizadora("Eventos SP", 123456789, "São Paulo");
            
            // Criando local
            Local local = new Local("Arena SP", 5000);
            
            // Criando evento
            EventoShow show = organizadora.criarEvento(
                "Show Rock SP", 
                local, 
                150.0, 
                "15/06/2024", 
                1000, 
                "Banda Rock"
            );
            
            // Criando cliente com email
            Cliente cliente = new Cliente("João Silva", "joao.silva@email.com");
            
            System.out.println("===== DEMONSTRAÇÃO DE NOTIFICAÇÕES POR EMAIL =====\n");
            
            // Demonstrando notificação ao comprar ingresso
            System.out.println("1. Comprando um ingresso:");
            try {
                show.venderIngresso(cliente);
                System.out.println("   Ingresso vendido com sucesso! Uma notificação foi enviada para o cliente.");
            } catch (IngressoEsgotadoException | EventoNaoEncontradoException e) {
                System.out.println("Erro ao vender ingresso: " + e.getMessage());
            }
            
            // Demonstrando o acesso às informações de email
            System.out.println("\n2. Acessando informações de email do cliente:");
            System.out.println("   Nome do cliente: " + cliente.getNome());
            System.out.println("   Endereço de email: " + cliente.getEnderecoEmail());
            
            // Nota sobre notificações personalizadas
            System.out.println("\n3. Sobre notificações personalizadas:");
            System.out.println("   A classe Email permite enviar notificações personalizadas para os clientes.");
            System.out.println("   Por exemplo: 'Olá " + cliente.getNome() + "! Temos uma promoção especial para você.'");
            
            // Demonstrando notificação ao cancelar ingresso
            System.out.println("\n4. Cancelando um ingresso:");
            try {
                cliente.cancelarIngresso(show);
                System.out.println("   Ingresso cancelado com sucesso! Uma notificação foi enviada para o cliente.");
            } catch (IngressoNaoEncontradoException | CancelamentoNaoPermitidoException e) {
                System.out.println("Erro ao cancelar ingresso: " + e.getMessage());
            }
            
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("Erro ao criar eventos: " + e.getMessage());
        }
    }
} 