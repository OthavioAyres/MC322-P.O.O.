/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

import java.util.List;
import lab02.exceptions.IngressoNaoEncontradoException;
import lab02.exceptions.CancelamentoNaoPermitidoException;

public class Cliente {

    private String nome;
    private String email;
    private List<Ingresso> ingressos;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     */
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
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
     * Retorna o email do cliente
     * @return o email do cliente
     */
    public String getEmail(){
        return email;
    }

    /**
     * Altera o email do cliente para `email` 
     * @param email o novo email do cliente
     */
    public void setEmail(String email){
        this.email = email;
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
    }

    /**
     * Adiciona uma lista de ingressos à lista de ingressos do cliente
     * @param novosIngressos a lista de ingressos a ser adicionada
     */
    public void adicionarIngresso(List<Ingresso> novosIngressos){
        for (Ingresso ingresso : novosIngressos) {
            ingressos.add(ingresso);
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
            throw new IngressoNaoEncontradoException("Ingresso não encontrado para o evento: " + evento.getNome());
        }

        // Verifica se o cancelamento é permitido (ex: ingresso gratuito)
        if (ingressoParaCancelar.getPreco() == 0) {
            throw new CancelamentoNaoPermitidoException("Não é permitido cancelar ingressos gratuitos");
        }

        // Remove o ingresso da lista
        ingressos.remove(ingressoParaCancelar);
    }
}