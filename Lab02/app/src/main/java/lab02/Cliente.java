/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

import java.util.List;
import java.util.ArrayList;
import lab02.exceptions.IngressoNaoEncontradoException;
import lab02.exceptions.CancelamentoNaoPermitidoException;

public class Cliente implements Comparable<Cliente> {

    private String nome;
    private Email email;
    private List<Ingresso> ingressos;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param enderecoEmail o endereço de email do cliente
     */
    public Cliente(String nome, String enderecoEmail){
        this.nome = nome;
        this.email = new Email(enderecoEmail);
        this.ingressos = new ArrayList<>();
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
}