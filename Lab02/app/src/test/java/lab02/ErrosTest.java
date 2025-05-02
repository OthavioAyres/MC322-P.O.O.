package lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import lab02.exceptions.*;

public class ErrosTest {
    
    @Test
    public void testVendaIngressosComCapacidadeLimitada() {
        try {
            // Configuração do ambiente
            Cliente cliente1 = new Cliente("Othavio", "tata@email.com");
            Cliente cliente2 = new Cliente("Henrique", "heheque@email.com");
            Cliente cliente3 = new Cliente("Carlos", "carlos@email.com");
            
            Organizadora organizadora = new Organizadora("Eventos Inc.", 123456789, "Rua dos Eventos, 123");
            Local localPequeno = new Local("Sala de Show", 2);
            
            // Criando evento com capacidade limitada
            EventoShow showPequeno = organizadora.criarEvento(
                "Show Exclusivo",
                localPequeno,
                500.0,
                "20/05/2024",
                2,
                "Artista Exclusivo"
            );
            
            // Testa venda de ingressos até a capacidade máxima
            showPequeno.venderIngresso(cliente1);
            showPequeno.venderIngresso(cliente2);
            
            // Verifica se os ingressos foram vendidos corretamente
            assertEquals(2, showPequeno.getQuantidadeIngressosVendidos(), 
                "Deve ter vendido exatamente 2 ingressos");
            
            // Testa tentativa de venda além da capacidade
            assertThrows(IngressoEsgotadoException.class, () -> {
                showPequeno.venderIngresso(cliente3);
            }, "Deve lançar exceção ao tentar vender além da capacidade");
            
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException | 
                 IngressoEsgotadoException | EventoNaoEncontradoException e) {
            fail("Erro inesperado: " + e.getMessage());
        }
    }
    
    @Test
    public void testLocalComCapacidadeInsuficiente() {
        // Configuração do ambiente
        Organizadora organizadora = new Organizadora("Eventos Inc.", 123456789, "Rua dos Eventos, 123");
        Local local = new Local("Sala de Show", 100);
        
        // Tenta criar evento com local indisponível
        assertThrows(CapacidadeInsuficienteException.class, () -> {
            organizadora.criarEvento(
                "Show Exclusivo",
                local,
                500.0,
                "20/05/2024",
                150, // Capacidade maior que a do local
                "Artista Exclusivo"
            );
        }, "Deve lançar exceção ao tentar criar evento com capacidade maior que a do local");
    }
} 