package lab01;

public class EventoShow extends Evento  implements FiltroEvento {
    private String Artista;
    private String data;

    public EventoShow(String nome, Local local, double precoIngresso , String Artista,  String data) {
        super(nome, local, precoIngresso);
        this.Artista = Artista;
        this.data = data;
    }
    
    public void exibirDetalhes () {
         System . out . println ( " Artista : " + this.Artista ) ;
         System . out . println ( " Data : " + this.data ) ;
        }

    @Override
    /**
     * Compara o artista do show com o artista do outro show
     * e retorna true para caos sejam iguais e false caso contrário
     */
    public boolean filtrar(Evento evento) {
        if (evento instanceof EventoShow) {
            EventoShow outroShow = ( EventoShow ) evento ;
            if (this.Artista.equals(outroShow.Artista ) ) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public String getArtista() {
        return Artista;
    }
}

