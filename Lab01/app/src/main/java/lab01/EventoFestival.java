package lab01;

import java.util.List;

public class EventoFestival extends Evento implements FiltroEvento{
    private List<String> bandas;
    private List<String> datas;

    public EventoFestival(String nome, Local local, double precoIngresso, List<String> bandas, List<String> datas) {
        super(nome, local, precoIngresso);
        this.bandas = bandas;
        this.datas = datas;
    }

    public void lineUp() {
        System.out.println("A LineUp é formada por" + this.bandas);
    }

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

    public void setBandas(List<String> bandas) {
        this.bandas = bandas;
    }

    public List<String> getBandas() {
        return bandas;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    public List<String> getDatas() {
        return datas;
    }

}
