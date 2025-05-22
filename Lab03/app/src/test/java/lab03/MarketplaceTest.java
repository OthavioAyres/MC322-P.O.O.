package lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import lab03.model.exceptions.OfertaNaoEncontradaException;
import lab03.model.Cliente;
import lab03.model.EventoShow;
import lab03.model.Ingresso;
import lab03.model.Marketplace;
import lab03.model.OfertaIngresso;
import lab03.model.Organizadora;
import lab03.model.exceptions.IngressoNaoPertenceAoClienteException;
import lab03.model.exceptions.SaldoInsuficienteException;

public class MarketplaceTest {
    private Marketplace marketplace;
    private Cliente vendedor;
    private Cliente comprador;
    private Organizadora organizadora;
    private EventoShow evento;
    private Ingresso ingresso;

    @BeforeEach
    void setUp() {
        // inicilizando o marketplace com 10% de comissão, clientes e organizadora
        marketplace = new Marketplace("Teste Marketplace", 10.0);
        
        organizadora = new Organizadora("Organizadora Teste", 123456789, "Endereço Teste");
        
        evento = new EventoShow("Show Teste", 100.0, organizadora, "2024-12-31", 1000, "Artista Teste");
        
        vendedor = new Cliente("Vendedor", "vendedor@email.com", 1000.0);
        comprador = new Cliente("Comprador", "comprador@email.com", 1000.0);
        
        ingresso = new Ingresso(evento, 100.0);
        vendedor.adicionarIngresso(ingresso);
    }

    @Test
    void testReceberOferta() {
        // Testa receber uma oferta válida
        OfertaIngresso oferta = marketplace.receberOferta(ingresso, 150.0, vendedor);
        
        assertTrue(marketplace.listarOfertas().contains(oferta));
        assertEquals(1, marketplace.listarOfertas().size());
    }

    @Test
    void testProcessarCompra() throws OfertaNaoEncontradaException, SaldoInsuficienteException {
        // Cria uma oferta
        OfertaIngresso oferta = marketplace.receberOferta(ingresso, 150.0, vendedor);
        
        // Processa a compra
        marketplace.processarCompra(comprador, oferta);
        
        // Verifica se o ingresso foi transferido
        assertTrue(comprador.getIngressos().contains(ingresso));
    }

    @Test
    void testProcessarCompraOfertaNaoEncontrada() {
        // Cria uma oferta que não está no marketplace
        OfertaIngresso oferta = new OfertaIngresso(ingresso, 150.0, vendedor);
        
        // Tenta processar a compra de uma oferta inexistente
        assertThrows(OfertaNaoEncontradaException.class, () -> {
            marketplace.processarCompra(comprador, oferta);
        });
    }

    @Test
    void testOferecerIngressoParaVenda() throws IngressoNaoPertenceAoClienteException {
        // Testa oferecer um ingresso para venda
        OfertaIngresso oferta = vendedor.oferecerIngressoParaVenda(ingresso, 150.0, marketplace);
        assertTrue(marketplace.listarOfertas().contains(oferta));
        assertFalse(vendedor.getIngressos().contains(ingresso));
    }

    @Test
    void testOferecerIngressoNaoPertenceAoCliente() {
        // Tenta oferecer um ingresso que não pertence ao cliente
        Ingresso outroIngresso = new Ingresso(evento, 100.0);
        
        assertThrows(IngressoNaoPertenceAoClienteException.class, () -> {
            vendedor.oferecerIngressoParaVenda(outroIngresso, 150.0, marketplace);
        });
    }


    @Test
    void testComprarIngressoSaldoInsuficiente() throws IngressoNaoPertenceAoClienteException {
        // Cria um comprador sem saldo
        Cliente compradorSemSaldo = new Cliente("Sem Saldo", "sem.saldo@teste.com", 0.0);
        
        // Cria uma oferta
        OfertaIngresso oferta = vendedor.oferecerIngressoParaVenda(ingresso, 150.0, marketplace);
        
        // Tenta comprar sem saldo suficiente
        assertThrows(SaldoInsuficienteException.class, () -> {
            compradorSemSaldo.comprarIngressoNoMarketplace(oferta, marketplace);
        });
    }
} 