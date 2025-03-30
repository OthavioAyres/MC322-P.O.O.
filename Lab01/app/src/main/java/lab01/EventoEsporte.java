package lab01;

public class EventoEsporte extends Evento implements FiltroEvento{
    private String time1;
    private String time2;
    private String data;
    /**
     * Construtor da classe EventoEsporte.
     * @param nome o nome do evento esportivo.
     * @param local o local onde o evento será realizado.
     * @param precoIngresso o preço do ingresso para o evento.
     * @param time1 o nome do primeiro time.
     * @param time2 o nome do segundo time.
     * @param data a data do evento.
     */
    public EventoEsporte(String nome, Local local, double precoIngresso, String time1, String time2, String data) {
        super(nome, local, precoIngresso);
        this.time1 = time1;
        this.time2 = time2;
        this.data = data;
    }

    /**
     * Exibe qual torcida é permitida no evento esportivo.
     */
    public void torcida() {
        System.out.println("A torcida permitida é do time: " + this.time1);
    }

    /**
     * Filtra eventos esportivos com base nos times participantes.
     * @param evento o evento a ser comparado.
     * @return true se o evento for do tipo EventoEsporte e os times forem iguais, caso contrário false.
     */
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

    /**
     * Define o nome do primeiro time.
     * @param time1 o nome do primeiro time.
     */
    public void setTime1(String time1) {
        this.time1 = time1;
    }

    /**
     * Retorna o nome do primeiro time.
     * @return o nome do primeiro time.
     */
    public String getTime1() {
        return time1;
    }

    /**
     * Define o nome do segundo time.
     * @param time2 o nome do segundo time.
     */
    public void setTime2(String time2) {
        this.time2 = time2;
    }

    /**
     * Retorna o nome do segundo time.
     * @return o nome do segundo time.
     */
    public String getTime2() {
        return time2;
    }

    /**
     * Define a data do evento esportivo.
     * @param data a data do evento.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Retorna a data do evento esportivo.
     * @return a data do evento.
     */
    public String getData() {
        return data;
    }
}
