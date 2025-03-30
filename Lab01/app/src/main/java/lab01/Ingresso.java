/*
 * Ingresso.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um Ingresso.
 * 
 * @Othavio Henrique de Jesus Ayres - 246666
 */
public abstract class Ingresso {
    private Evento evento;

    /**
     * Retorna o Evento
     * @return o Evento
     */
    public Evento getEvento(){
        return evento;
    }

    /**
     * Construtor da classe Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public Ingresso(Evento evento){
        this.evento = evento;
    }

    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */
    public abstract double getPreco();
    
}
