/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab03.model;

import java.util.List;
import java.util.ArrayList;
import lab03.model.exceptions.IngressoNaoEncontradoException;
import lab03.model.exceptions.CancelamentoNaoPermitidoException;
import lab03.model.exceptions.SaldoInsuficienteException;
import lab03.model.exceptions.IngressoNaoPertenceAoClienteException;
import lab03.model.exceptions.OfertaNaoEncontradaException;

public class Cliente implements Comparable<Cliente> {

    private String nome;
    private Email email;
    private List<Ingresso> ingressos;
    private double saldo;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param enderecoEmail o endereço de email do cliente
     */
    public Cliente(String nome, String enderecoEmail){
        this.nome = nome;
        this.email = new Email(enderecoEmail);
        this.ingressos = new ArrayList<>();
        this.saldo = 0.0;
    }

    /**
     * Construtor da classe cliente com saldo inicial
     * @param nome o nome do cliente
     * @param enderecoEmail o endereço de email do cliente
     * @param saldoInicial o saldo inicial do cliente
     */
    public Cliente(String nome, String enderecoEmail, double saldoInicial){
        this.nome = nome;
        this.email = new Email(enderecoEmail);
        this.ingressos = new ArrayList<>();
        this.saldo = saldoInicial;
    }

    /**
     * Retorna o nome do cliente
     * @return o nome do cliente
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do cliente
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o objeto email do cliente
     * @return o objeto Email do cliente
     */
    public Email getEmail(){
        return email;
    }

    /**
     * Retorna o endereço de email do cliente
     * @return o endereço de email do cliente
     */
    public String getEnderecoEmail(){
        return email.getEndereco();
    }

    /**
     * Altera o email do cliente para `enderecoEmail` 
     * @param enderecoEmail o novo endereço de email do cliente
     */
    public void setEnderecoEmail(String enderecoEmail){
        this.email.setEndereco(enderecoEmail);
    }

    /**
     * Retorna a lista de ingressos do cliente
     * @return a lista de ingressos do cliente
     */
    public List<Ingresso> getIngressos(){
        return ingressos;
    }

    /**
     * Adiciona um ingresso à lista de ingressos do cliente
     * @param ingresso o ingresso a ser adicionado
     */ 
    public void adicionarIngresso(Ingresso ingresso){
        ingressos.add(ingresso);
        // Notifica o cliente sobre a compra do ingresso
        String assunto = "Confirmação de compra de ingresso";
        String mensagem = "Sua compra para o evento '" + ingresso.getEvento().getNome() + 
                         "' no dia " + ingresso.getEvento().getData() + 
                         " foi confirmada com sucesso!";
        email.exibirNotificacao(assunto, mensagem);
    }

    /**
     * Adiciona uma lista de ingressos à lista de ingressos do cliente
     * @param novosIngressos a lista de ingressos a ser adicionada
     */
    public void adicionarIngresso(List<Ingresso> novosIngressos){
        for (Ingresso ingresso : novosIngressos) {
            ingressos.add(ingresso);
            // Notifica o cliente sobre a compra de cada ingresso
            String assunto = "Confirmação de compra de ingresso";
            String mensagem = "Sua compra para o evento '" + ingresso.getEvento().getNome() + 
                         "' no dia " + ingresso.getEvento().getData() + 
                         " foi confirmada com sucesso!";
            email.exibirNotificacao(assunto, mensagem);
        }
    }

    /**
     * Remove um ingresso da lista de ingressos do cliente
     * @param ingresso o ingresso a ser removido
     */
    public void removerIngresso(Ingresso ingresso){
        ingressos.remove(ingresso);
    }

    /**
     * Cancela um ingresso para um evento específico
     * @param evento o evento para o qual o ingresso será cancelado
     * @throws IngressoNaoEncontradoException se o cliente não possuir ingresso para o evento
     * @throws CancelamentoNaoPermitidoException se o cancelamento não for permitido (ex: evento já ocorreu)
     */
    public void cancelarIngresso(Evento evento) throws IngressoNaoEncontradoException, CancelamentoNaoPermitidoException {
        // Verifica se o cliente possui ingresso para o evento
        Ingresso ingressoParaCancelar = null;
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getEvento().equals(evento)) {
                ingressoParaCancelar = ingresso;
                break;
            }
        }

        if (ingressoParaCancelar == null) {
            throw new IngressoNaoEncontradoException("Ingresso não encontrado para o evento - " + evento.getNome());
        }

        // Verifica se o cancelamento é permitido (ex: ingresso gratuito)
        if (ingressoParaCancelar.getPreco() == 0) {
            throw new CancelamentoNaoPermitidoException("Não é permitido cancelar ingressos gratuitos");
        }

        // Remove o ingresso da lista
        ingressos.remove(ingressoParaCancelar);
        
        String assunto = "Cancelamento de ingresso";
        String mensagem = "Seu ingresso para o evento '" + evento.getNome() + 
                         "' no dia " + evento.getData() + 
                         " foi cancelado com sucesso!";
        email.exibirNotificacao(assunto, mensagem);
    }
    
    /**
     * Compara se este cliente possui ingressos para o mesmo evento que outro cliente
     * @param outroCliente o cliente a ser comparado
     * @return 0 se ambos possuem ingressos para pelo menos um evento em comum,
     *         1 se não possuem ingressos para eventos em comum
     */
    @Override
    public int compareTo(Cliente outroCliente) {
        // Verificar se os clientes possuem ingressos para os mesmos eventos
        for (Ingresso meuIngresso : this.ingressos) {
            for (Ingresso outroIngresso : outroCliente.getIngressos()) {
                // Se encontrarmos pelo menos um evento em comum, retorna 0 (iguais)
                if (meuIngresso.getEvento().equals(outroIngresso.getEvento())) {
                    return 0;
                }
            }
        }
        // Se não encontrou eventos em comum, retorna 1 (diferentes)
        return 1;
    }

    /**
     * Retorna o saldo atual do cliente
     * @return o saldo atual
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Adiciona um valor ao saldo do cliente
     * @param valor o valor a ser adicionado
     */
    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            
            String assunto = "Crédito adicionado";
            String mensagem = "Foi adicionado R$" + valor + " ao seu saldo. Saldo atual: R$" + this.saldo;
            email.exibirNotificacao(assunto, mensagem);
        }
    }

    /**
     * Debita um valor do saldo do cliente
     * @param valor o valor a ser debitado
     * @throws SaldoInsuficienteException se o cliente não possuir saldo suficiente
     */
    public void debitarSaldo(double valor) throws SaldoInsuficienteException {
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar a operação");
        }
        
        this.saldo -= valor;
        
        String assunto = "Débito realizado";
        String mensagem = "Foi debitado R$" + valor + " do seu saldo. Saldo atual: R$" + this.saldo;
        email.exibirNotificacao(assunto, mensagem);
    }

    /**
     * Oferece um ingresso para venda no marketplace
     * @param ingresso o ingresso a ser vendido
     * @param precoPedido o preço solicitado
     * @param marketplace o marketplace onde o ingresso será vendido
     * @return a oferta criada
     * @throws IngressoNaoPertenceAoClienteException se o cliente não possuir o ingresso
     */
    public OfertaIngresso oferecerIngressoParaVenda(Ingresso ingresso, double precoPedido, Marketplace marketplace) 
            throws IngressoNaoPertenceAoClienteException {
        // Verifica se o cliente possui o ingresso
        if (!ingressos.contains(ingresso)) {
            throw new IngressoNaoPertenceAoClienteException("O ingresso não pertence ao cliente " + this.nome);
        }
        
        // Remove o ingresso da lista do cliente
        ingressos.remove(ingresso);
        
        // Adiciona o ingresso ao marketplace
        OfertaIngresso oferta = marketplace.receberOferta(ingresso, precoPedido, this);
        
        // Notifica o cliente sobre a oferta
        String assunto = "Ingresso oferecido para venda";
        String mensagem = "Seu ingresso para o evento '" + ingresso.getEvento().getNome() + 
                         "' foi colocado à venda por R$" + precoPedido;
        email.exibirNotificacao(assunto, mensagem);
        
        return oferta;
    }

    /**
     * Compra um ingresso do marketplace
     * @param oferta a oferta de ingresso a ser comprada
     * @param marketplace o marketplace onde a compra será realizada
     * @throws SaldoInsuficienteException se o cliente não possuir saldo suficiente
     * @throws OfertaNaoEncontradaException se a oferta não existir no marketplace
     */
    public void comprarIngressoNoMarketplace(OfertaIngresso oferta, Marketplace marketplace) 
            throws SaldoInsuficienteException, OfertaNaoEncontradaException {
        // Verifica se a oferta existe no marketplace
        if (!marketplace.listarOfertas().contains(oferta)) {
            throw new OfertaNaoEncontradaException("A oferta não está disponível no marketplace");
        }
        
        // Verifica se o cliente tem saldo suficiente
        if (this.saldo < oferta.getPrecoPedido()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para comprar o ingresso. Saldo atual: R$" + this.saldo);
        }
        
        // Debita o valor do saldo do cliente
        debitarSaldo(oferta.getPrecoPedido());
        
        // Calcula a comissão e o valor líquido para o vendedor
        double valorComissao = oferta.getPrecoPedido() * (marketplace.getComissaoPorcentagem() / 100.0);
        double valorLiquido = oferta.getPrecoPedido() - valorComissao;
        
        // Adiciona o valor líquido ao saldo do vendedor
        oferta.getVendedor().adicionarSaldo(valorLiquido);
        
        // Processa a compra no marketplace
        marketplace.processarCompra(this, oferta);
    }
}