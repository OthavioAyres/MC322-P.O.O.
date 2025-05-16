/*
 * Local.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab03.model;

import lab03.model.exceptions.CapacidadeInsuficienteException;
import lab03.model.exceptions.LocalIndisponivelException;

/**
 * Contém a estrutura de implementação de um Local.
 * 
 * @author Gabriel Leite - 216180
 */
public class Local{
    private String nome;
    private double capacidadeMaxima;
    private Evento eventoAlocado;

    /**
     * Construtor da classe Local
     * @param nome o nome do local
     */
    public Local(String nome, double capacidadeMaxima){
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.eventoAlocado = null;
    }

    /**
     * Retorna o nome do evento
     * @return o nome do evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna a capacidade do local
     * @return a capacidade do local
     */
    public double getCapacidade(){
        return capacidadeMaxima;
    }
    
    /**
     * Altera a capacidade máxima do local para `capacidadeMaxima` 
     * @param capacidadeMaxima a nova capacidade máxima do local
     */
    public void setCapacidade(double capacidadeMaxima){
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /**
     * Aloca o local para um evento
     * @param evento o evento a ser alocado
     * @throws CapacidadeInsuficienteException se a capacidade do local for menor que a quantidade de participantes do evento
     * @throws LocalIndisponivelException se o local já estiver alocado para outro evento
     */
    public void alocarParaEvento(Evento evento) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        if (eventoAlocado != null) {
            throw new LocalIndisponivelException("O local " + nome + " já está alocado para outro evento");
        }
        
        if (evento.getQuantidadeParticipantes() > capacidadeMaxima) {
            throw new CapacidadeInsuficienteException("A capacidade do local " + nome + " é insuficiente para o evento");
        }
        evento.setLocal(this);
        this.eventoAlocado = evento;
    }


    /**
     * Retorna o evento alocado no local
     * @return o evento alocado ou null se não houver evento alocado
     */
    public Evento getEventoAlocado() {
        return eventoAlocado;
    }
}
