package lab02;

import java.util.List;

public class Organizadora {

    private String nome;
    private int cnpj;
    private String endereco;

    /**
     * Construtor da classe Organizadora
     * @param nome o nome da organizadora
     * @param cnpj o CNPJ da organizadora
     * @param endereco o endereço da organizadora
     */
    public Organizadora(String nome, int cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    /**
     * Cria um evento do tipo Festival
     * @param nome o nome do Festival
     * @param local o local do Festival
     * @param precoBase o preço base do ingresso
     * @param dataInicio a data de início do Festival
     * @param dataFim a data de fim do Festival
     * @param lineup a lista de artistas do Festival
     * @param duracao a duração do Festival em dias
     * @return um novo EventoFestival
     */
    public EventoFestival criarEvento(String nome, Local local, double precoBase, String dataInicio, String dataFim, List<String> lineup, int duracao) {
        return new EventoFestival(nome, local, precoBase, this, dataInicio, lineup, duracao);
    }

    /**
     * Cria um evento do tipo Show
     * @param nome o nome do Show
     * @param local o local do Show
     * @param precoBase o preço base do ingresso
     * @param data a data do Show
     * @param artista o artista do Show
     * @return um novo EventoShow
     */
    public EventoShow criarEvento(String nome, Local local, double precoBase, String data, String artista) {
        return new EventoShow(nome, local, precoBase, this, data, artista);
    }

    /**
     * Cria um evento do tipo Jogo
     * @param nome o nome do Jogo
     * @param local o local do Jogo
     * @param precoBase o preço base do ingresso
     * @param data a data do Jogo
     * @param times a lista de times que jogarão
     * @return um novo EventoJogo
     */
    public EventoJogo criarEvento(String nome, Local local, double precoBase, String data, List<String> times) {
        return new EventoJogo(nome, local, precoBase, this, data, times);
    }
}
