/*
 * Marketplace.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03.model;

import java.util.List;
import java.util.ArrayList;
import lab03.model.exceptions.OfertaNaoEncontradaException;

/**
 * Classe responsável por gerenciar os ingressos que estão sendo oferecidos para venda por outros usuários.
 */
public class Marketplace {

    private String nome;
    private double comissaoPorcentagem;
    private List<OfertaIngresso> ofertasDisponiveis;

    /**
     * Construtor da classe Marketplace
     * @param nome o nome do marketplace
     * @param comissaoPorcentagem a porcentagem de comissão cobrada pelo sistema (entre 0 e 100)
     */
    public Marketplace(String nome, double comissaoPorcentagem) {
        this.nome = nome;
        this.comissaoPorcentagem = comissaoPorcentagem;
        this.ofertasDisponiveis = new ArrayList<>();
    }

    /**
     * Retorna o nome do marketplace
     * @return o nome do marketplace
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a lista de ofertas disponíveis no marketplace
     * @return lista de ofertas de ingressos
     */
    public List<OfertaIngresso> listarOfertas() {
        return ofertasDisponiveis;
    }

    /**
     * Adiciona um ingresso à lista de ofertas do marketplace
     * @param ingresso o ingresso a ser vendido
     * @param precoPedido o preço solicitado pelo vendedor
     * @param vendedor o cliente que está vendendo o ingresso
     * @return a oferta de ingresso criada
     */
    public OfertaIngresso receberOferta(Ingresso ingresso, double precoPedido, Cliente vendedor) {
        OfertaIngresso oferta = new OfertaIngresso(ingresso, precoPedido, vendedor);
        ofertasDisponiveis.add(oferta);
        return oferta;
    }

    /**
     * Remove a oferta do marketplace e transfere a propriedade do ingresso
     * @param comprador o cliente que está comprando o ingresso
     * @param oferta a oferta de ingresso a ser processada
     * @throws OfertaNaoEncontradaException se a oferta não existir no marketplace
     */
    public void processarCompra(Cliente comprador, OfertaIngresso oferta) throws OfertaNaoEncontradaException {
        if (!ofertasDisponiveis.contains(oferta)) {
            throw new OfertaNaoEncontradaException("A oferta não está disponível no marketplace");
        }
        comprador.adicionarIngresso(oferta.getIngresso());
        ofertasDisponiveis.remove(oferta);
    }

    /**
     * Retorna a porcentagem de comissão do marketplace
     * @return a porcentagem de comissão
     */
    public double getComissaoPorcentagem() {
        return comissaoPorcentagem;
    }

    /**
     * Define a porcentagem de comissão do marketplace
     * @param comissaoPorcentagem a nova porcentagem de comissão (entre 0 e 100)
     */
    public void setComissaoPorcentagem(double comissaoPorcentagem) {
        this.comissaoPorcentagem = comissaoPorcentagem;
    }
} 