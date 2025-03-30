/*
 * Evento.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de um Evento.
 * 
 * @Othavio Henrique de Jesus Ayres - 246666
 */
public abstract class Evento {
    private String nome;
    private Local local;
    private double precoIngresso;
    private List<Ingresso> ingressosVendidos = new ArrayList<Ingresso>();
    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param local o local associado ao Evento
     */
    public Evento(String nome, Local local, double precoIngresso){
        this.nome = nome;
        this.local = local;
        this.precoIngresso = precoIngresso;
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
     * Retorna o objeto Local associado ao Evento.
     * @return o objeto Local do Evento.
     */
    public Local getLocal(){
        return local;
    }

    /**
     * Retorna o preço padrão do ingresso do Evento.
     * @return o preço do ingresso do Evento.
     */
    public double getPrecoIngresso(){
        return precoIngresso;
    }

    /**
     * Atualiza o preço padrão do ingresso do Evento.
     * @param precoIngresso o novo preço do ingresso do Evento.
     */
    public void setPrecoIngresso(double precoIngresso){
        this.precoIngresso = precoIngresso;
    }

    /**
     * Retorna a lista de ingressos vendidos para o Evento.
     * @return a lista de ingressos vendidos.
     */
    public List<Ingresso> getIngressosVendidos(){
        return ingressosVendidos;
    }

    /**
     * Adiciona um ingresso à lista de ingressos vendidos e associa o ingresso ao usuário.
     * @param ingresso o ingresso a ser adicionado.
     * @param usuario o usuário que comprou o ingresso.
     */
    public void adicionarIngresso(Ingresso ingresso, Usuario usuario){
        usuario.setIngresso(ingresso);
        ingressosVendidos.add(ingresso);
    }

    /**
     * Calcula o faturamento total do Evento com base nos ingressos vendidos.
     * @return o faturamento total do Evento.
     */
    public double calcularFaturamento(){
        double faturamento = 0.0;
        for (Ingresso ingresso : ingressosVendidos) {
            faturamento += ingresso.getPreco();
        }
        return faturamento;
    }

    /**
     * Retorna a capacidade máxima do local onde o Evento será realizado.
     * @return a capacidade do local do Evento.
     */
    public double getCapacidade(){
        return local.getCapacidade();
    }
}
