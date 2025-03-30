package lab01;

import java.util.List;

public class EventoTeatro extends Evento implements FiltroEvento{
    private String peca;
    private List<String> atores;
    private String data;

    /**
     * Construtor da classe EventoTeatro.
     * @param nome o nome do evento teatral.
     * @param local o local onde o evento será realizado.
     * @param precoIngresso o preço do ingresso para o evento.
     * @param peca o nome da peça teatral.
     * @param atores a lista de atores que participarão da peça.
     * @param data a data em que o evento ocorrerá.
     */
    public EventoTeatro(String nome, Local local, double precoIngresso, String peca, List<String> atores, String data) {
        super(nome, local, precoIngresso);
        this.peca = peca;
        this.atores = atores;
        this.data = data;
    }
    
    /**
     * Exibe uma propaganda do evento teatral, incluindo o nome da peça, os atores e a data do evento.
     */
    public void propaganda () {
         System.out.println("Estrelaremos a peça " + this.peca);
         System.out.println("Com a brilhante atuação de" + this.atores);
         System.out.println("Imperdível!!! Corra para comprar nossos ingressos disponíveis até: " + this.data);
    }

    @Override
    /**
     * Filtra eventos do tipo EventoTeatro com base no nome da peça.
     * @param evento o evento a ser comparado.
     * @return true se o evento for do tipo EventoTeatro e o nome da peça for o mesmo, caso contrário false.
     */
    public boolean filtrar(Evento evento) {
        if (evento instanceof EventoTeatro) {
            EventoTeatro outroTeatro = (EventoTeatro) evento;
            if (this.peca.equals(outroTeatro.peca)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Define o nome da peça teatral.
     * @param peca o nome da peça.
     */
    public void setPeca(String peca) {
        this.peca = peca;
    }

    /**
     * Retorna o nome da peça teatral.
     * @return o nome da peça.
     */
    public String getPeca() {
        return peca;
    }

    /**
     * Define a lista de atores que participarão da peça.
     * @param atores a lista de atores.
     */
    public void setAtores(List<String> atores) {
        this.atores = atores;
    }

    /**
     * Retorna a lista de atores que participarão da peça.
     * @return a lista de atores.
     */
    public List<String> getAtores() {
        return atores;
    }

    /**
     * Define a data do evento teatral.
     * @param data a data do evento.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Retorna a data do evento teatral.
     * @return a data do evento.
     */
    public String getData() {
        return data;
    }
}

