package lab01;

import java.util.List;

public class EventoFestival extends Evento implements FiltroEvento{
    private List<String> bandas;
    private List<String> datas;

    /**
     * Construtor da classe EventoFestival.
     * @param nome o nome do festival.
     * @param local o local onde o festival será realizado.
     * @param precoIngresso o preço do ingresso para o festival.
     * @param bandas a lista de bandas que irão se apresentar no festival.
     * @param datas as datas em que o festival ocorrerá.
     */
    public EventoFestival(String nome, Local local, double precoIngresso, List<String> bandas, List<String> datas) {
        super(nome, local, precoIngresso);
        this.bandas = bandas;
        this.datas = datas;
    }

    /**
     * Exibe a LineUp do festival, ou seja, a lista de bandas que irão se apresentar.
     */
    public void lineUp() {
        System.out.println("A LineUp é formada por" + this.bandas);
    }

    /**
     * Filtra eventos do tipo EventoFestival com base na lista de bandas.
     * @param evento o evento a ser comparado.
     * @return true se o evento for do tipo EventoFestival e as listas de bandas forem iguais, caso contrário false.
     */
    @Override
    public boolean filtrar(Evento evento) {
        if (evento instanceof EventoFestival) {
            EventoFestival outroFestival = (EventoFestival) evento;
            if (this.bandas.equals(outroFestival.bandas)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Define a lista de bandas que irão se apresentar no festival.
     * @param bandas a lista de bandas.
     */
    public void setBandas(List<String> bandas) {
        this.bandas = bandas;
    }

    /**
     * Retorna a lista de bandas que irão se apresentar no festival.
     * @return a lista de bandas.
     */
    public List<String> getBandas() {
        return bandas;
    }

    /**
     * Define as datas em que o festival ocorrerá.
     * @param datas a lista de datas.
     */
    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    /**
     * Retorna as datas em que o festival ocorrerá.
     * @return a lista de datas.
     */
    public List<String> getDatas() {
        return datas;
    }
}
