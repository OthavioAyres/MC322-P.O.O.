/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import lab02.exceptions.IngressoEsgotadoException;
import lab02.exceptions.EventoNaoEncontradoException;

public abstract class Evento {
    protected String nome;
    protected Local local;
    protected double precoIngresso; // preço base do ingresso
    protected Organizadora organizadora;
    protected String data;
    protected double quantidadeParticipantes;
    protected double quantidadeIngressosVendidos;
    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param local o local associado ao Evento
     */
    public Evento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data) {
        this.nome = nome;
        this.local = local;
        this.precoIngresso = precoIngresso; // modificar para representar o preço base do ingresso
        this.organizadora = organizadora;
        this.data = data;
        this.quantidadeParticipantes = local.getCapacidade();
        this.quantidadeIngressosVendidos = 0;
    }

    /**
     * Retorna o nome do Evento
     * @return o nome do Evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do Evento para `nome` 
     * @param nome o novo nome do Evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o Local do Evento
     * @return o local do Evento
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Altera o local do Evento para `local` 
     * @param local o novo local do Evento
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Retorna o preço do ingresso do Evento
     * @return o precoIngresso do Evento
     */
    public double getPrecoIngresso(){
        return this.precoIngresso;
    }

    /**
     * Altera o precoIngresso do Evento para `precoIngresso` 
     * @param precoIngresso o novo precoIngresso do Evento
     */
    public void setPrecoIngresso(double precoIngresso){
        this.precoIngresso = precoIngresso;
    }

    public String descricao(){
        return "Evento: " + this.nome + " - Local: " + this.local;
    }

    /**
     * Retorna a data do Evento
     * @return a data do Evento
     */
    public String getData() {
        return data;
    }

    /**
     * Vende um ingresso para um cliente
     * @param cliente o cliente que está comprando o ingresso
     * @return o ingresso vendido
     * @throws IngressoEsgotadoException se não houver mais ingressos disponíveis
     * @throws EventoNaoEncontradoException se o evento não for encontrado
     */
    public Ingresso venderIngresso(Cliente cliente) throws IngressoEsgotadoException, EventoNaoEncontradoException {
        if (this == null) {
            throw new EventoNaoEncontradoException("Evento não encontrado");
        }
        
        if (this.quantidadeIngressosVendidos >= this.quantidadeParticipantes) {
            throw new IngressoEsgotadoException("Ingressos esgotados para o evento: " + this.nome);
        }
        
        Ingresso ingresso = new Ingresso(this, this.precoIngresso);
        cliente.adicionarIngresso(ingresso);
        this.quantidadeIngressosVendidos++;
        
        return ingresso;
    }

    /**
     * Retorna a quantidade de participantes do Evento
     * @return a quantidade de participantes do Evento
     */
    public double getQuantidadeParticipantes() {
        return quantidadeParticipantes;
    }

    /**
     * Retorna a quantidade de ingressos vendidos do Evento
     * @return a quantidade de ingressos vendidos do Evento
     */
    public double getQuantidadeIngressosVendidos() {
        return quantidadeIngressosVendidos;
    }
}