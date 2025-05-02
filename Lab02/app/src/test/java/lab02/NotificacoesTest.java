package lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import lab02.exceptions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NotificacoesTest {
    
    @Test
    public void testNotificacaoCompraIngresso() {
        try {
            // Configuração do ambiente
            Organizadora organizadora = new Organizadora("Eventos SP", 123456789, "São Paulo");
            Local local = new Local("Arena SP", 5000);
            EventoShow show = organizadora.criarEvento(
                "Show Rock SP", 
                local, 
                150.0, 
                "15/06/2024", 
                1000, 
                "Banda Rock"
            );
            Cliente cliente = new Cliente("João Silva", "joao.silva@email.com");
            
            // Redireciona a saída padrão para capturar as notificações
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            
            // Testa a compra do ingresso
            show.venderIngresso(cliente);
            
            // Verifica se a notificação foi enviada
            String output = outContent.toString();
            assertTrue(output.contains("NOTIFICAÇÃO POR EMAIL"));
            assertTrue(output.contains("joao.silva@email.com"));
            assertTrue(output.contains("Confirmação de compra de ingresso"));
            assertTrue(output.contains("Show Rock SP"));
            
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException | 
                 IngressoEsgotadoException | EventoNaoEncontradoException e) {
            fail("Erro inesperado: " + e.getMessage());
        }
    }
    
    @Test
    public void testNotificacaoCancelamentoIngresso() {
        try {
            // Configuração do ambiente
            Organizadora organizadora = new Organizadora("Eventos SP", 123456789, "São Paulo");
            Local local = new Local("Arena SP", 5000);
            EventoShow show = organizadora.criarEvento(
                "Show Rock SP", 
                local, 
                150.0, 
                "15/06/2024", 
                1000, 
                "Banda Rock"
            );
            Cliente cliente = new Cliente("João Silva", "joao.silva@email.com");
            
            // Compra o ingresso primeiro
            show.venderIngresso(cliente);
            
            // Redireciona a saída padrão para capturar as notificações
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            
            // Testa o cancelamento do ingresso
            cliente.cancelarIngresso(show);
            
            // Verifica se a notificação foi enviada
            String output = outContent.toString();
            assertTrue(output.contains("NOTIFICAÇÃO POR EMAIL"));
            assertTrue(output.contains("joao.silva@email.com"));
            assertTrue(output.contains("Cancelamento de ingresso"));
            assertTrue(output.contains("Show Rock SP"));
            
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException | 
                 IngressoEsgotadoException | EventoNaoEncontradoException |
                 IngressoNaoEncontradoException | CancelamentoNaoPermitidoException e) {
            fail("Erro inesperado: " + e.getMessage());
        }
    }
    
    @Test
    public void testErroCancelamentoIngressoInexistente() {
        try {
            // Configuração do ambiente
            Organizadora organizadora = new Organizadora("Eventos SP", 123456789, "São Paulo");
            Local local = new Local("Arena SP", 5000);
            EventoShow show = organizadora.criarEvento(
                "Show Rock SP", 
                local, 
                150.0, 
                "15/06/2024", 
                1000, 
                "Banda Rock"
            );
            Cliente cliente = new Cliente("João Silva", "joao.silva@email.com");
            
            // Tenta cancelar um ingresso que não existe
            assertThrows(IngressoNaoEncontradoException.class, () -> {
                cliente.cancelarIngresso(show);
            });
            
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e) {
            fail("Erro inesperado: " + e.getMessage());
        }
    }
} 