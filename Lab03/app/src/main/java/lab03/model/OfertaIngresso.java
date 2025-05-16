/*
 * OfertaIngresso.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03.model;

/**
 * Classe que representa uma oferta de ingresso no Marketplace.
 */
public class OfertaIngresso {

    private Ingresso ingresso;
    private double precoPedido;
    private Cliente vendedor;

    /**
     * Construtor da classe OfertaIngresso
     * @param ingresso o ingresso sendo oferecido
     * @param precoPedido o preço solicitado pelo vendedor
     * @param vendedor o cliente que está vendendo o ingresso
     */
    public OfertaIngresso(Ingresso ingresso, double precoPedido, Cliente vendedor) {
        this.ingresso = ingresso;
        this.precoPedido = precoPedido;
        this.vendedor = vendedor;
    }

    /**
     * Retorna o ingresso da oferta
     * @return o ingresso da oferta
     */
    public Ingresso getIngresso() {
        return ingresso;
    }

    /**
     * Retorna o preço pedido pelo vendedor
     * @return o preço pedido pelo vendedor
     */
    public double getPrecoPedido() {
        return precoPedido;
    }

    /**
     * Define o preço pedido pelo vendedor
     * @param precoPedido o novo preço pedido
     */
    public void setPrecoPedido(double precoPedido) {
        this.precoPedido = precoPedido;
    }

    /**
     * Retorna o vendedor do ingresso
     * @return o cliente vendedor
     */
    public Cliente getVendedor() {
        return vendedor;
    }

    @Override
    public String toString() {
        return String.format("Evento: %s - Preço: R$ %.2f - Vendedor: %s", 
                ingresso.getEvento().getNome(), 
                precoPedido, 
                vendedor.getNome());
    }
} 