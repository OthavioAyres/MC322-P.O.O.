package lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import lab02.exceptions.IngressoEsgotadoException;
import lab02.exceptions.EventoNaoEncontradoException;

public class ClienteComparacaoTest {
    
    @Test
    public void testClientesComIngressosParaMesmoEvento() {
        // Cenário 1: Dois clientes com ingressos para o mesmo evento
        Evento eventoComum = new EventoShow("Concerto de Rock", 50.0, null, "2023-10-01", 100, "Banda XYZ");
        Cliente cliente1 = new Cliente("João", "joao@email.com");
        Cliente cliente2 = new Cliente("Maria", "maria@email.com");
        
        try {
            eventoComum.venderIngresso(cliente1);
            eventoComum.venderIngresso(cliente2);
            
            // Verifica se a comparação retorna 0 (clientes com ingressos para o mesmo evento)
            assertEquals(0, cliente1.compareTo(cliente2), 
                "Clientes com ingressos para o mesmo evento devem retornar 0 na comparação");
        } catch (IngressoEsgotadoException | EventoNaoEncontradoException e) {
            fail("Erro ao vender ingressos: " + e.getMessage());
        }
    }
    
    @Test
    public void testClientesSemIngressosParaMesmoEvento() {
        // Cenário 2: Dois clientes sem ingressos para o mesmo evento
        Evento eventoDiferente = new EventoShow("Festival de Jazz", 60.0, null, "2023-11-01", 150, "Músico ABC");
        Cliente cliente3 = new Cliente("Pedro", "pedro@email.com");
        Cliente cliente4 = new Cliente("Ana", "ana@email.com");
        
        try {
            eventoDiferente.venderIngresso(cliente3);
            // cliente4 não tem nenhum ingresso
            
            // Verifica se a comparação retorna 1 (clientes sem ingressos para o mesmo evento)
            assertEquals(1, cliente3.compareTo(cliente4), 
                "Clientes sem ingressos para o mesmo evento devem retornar 1 na comparação");
        } catch (IngressoEsgotadoException | EventoNaoEncontradoException e) {
            fail("Erro ao vender ingressos: " + e.getMessage());
        }
    }
    
    @Test
    public void testClientesComIngressosParaEventosDiferentes() {
        // Cenário 3: Dois clientes com ingressos para eventos diferentes
        Evento evento1 = new EventoShow("Concerto de Rock", 50.0, null, "2023-10-01", 100, "Banda XYZ");
        Evento evento2 = new EventoShow("Festival de Jazz", 60.0, null, "2023-11-01", 150, "Músico ABC");
        Cliente cliente1 = new Cliente("João", "joao@email.com");
        Cliente cliente2 = new Cliente("Maria", "maria@email.com");
        
        try {
            evento1.venderIngresso(cliente1);
            evento2.venderIngresso(cliente2);
            
            // Verifica se a comparação retorna 1 (clientes com ingressos para eventos diferentes)
            assertEquals(1, cliente1.compareTo(cliente2), 
                "Clientes com ingressos para eventos diferentes devem retornar 1 na comparação");
        } catch (IngressoEsgotadoException | EventoNaoEncontradoException e) {
            fail("Erro ao vender ingressos: " + e.getMessage());
        }
    }
} 