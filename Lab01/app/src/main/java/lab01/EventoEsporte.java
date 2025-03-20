package lab01;

public class EventoEsporte extends Evento implements FiltroEvento{
    private String time1;
    private String time2;
    private String data;

    public EventoEsporte(String nome, Local local, double precoIngresso, String time1, String time2, String data) {
        super(nome, local, precoIngresso);
        this.time1 = time1;
        this.time2 = time2;
        this.data = data;
    }

    public void torcida() {
        System.out.println("A torcida permitida é do time: " + this.time1);
    }

    @Override
    public boolean filtrar(Evento evento) {
        if (evento instanceof EventoEsporte) {
            EventoEsporte outroEsporte = (EventoEsporte) evento;
            if (this.time1.equals(outroEsporte.time1) && this.time2.equals(outroEsporte.time2)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime2() {
        return time2;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
