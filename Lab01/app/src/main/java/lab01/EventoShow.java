package lab01;

public class EventoShow extends Evento  implements FiltroEvento {
    private String Artista;
    private String data;

    /**
     * Construtor da classe EventoShow.
     * @param nome o nome do show.
     * @param local o local onde o show será realizado.
     * @param precoIngresso o preço do ingresso para o show.
     * @param Artista o nome do artista principal do show.
     * @param data a data em que o show ocorrerá.
     */
    public EventoShow(String nome, Local local, double precoIngresso , String Artista,  String data) {
        super(nome, local, precoIngresso);
        this.Artista = Artista;
        this.data = data;
    }
    
    /**
     * Exibe os detalhes do show, incluindo o nome do artista e a data do evento.
     */
    public void exibirDetalhes () {
         System.out.println("Artista: " + this.Artista);
         System.out.println("Data: " + this.data);
    }

    @Override
    /**
     * Filtra eventos do tipo EventoShow com base no artista principal.
     * @param evento o evento a ser comparado.
     * @return true se o evento for do tipo EventoShow e o artista for o mesmo, caso contrário false.
     */
    public boolean filtrar(Evento evento) {
        if (evento instanceof EventoShow) {
            EventoShow outroShow = (EventoShow) evento;
            if (this.Artista.equals(outroShow.Artista)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Define o nome do artista principal do show.
     * @param Artista o nome do artista.
     */
    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    /**
     * Retorna o nome do artista principal do show.
     * @return o nome do artista.
     */
    public String getArtista() {
        return Artista;
    }
}

