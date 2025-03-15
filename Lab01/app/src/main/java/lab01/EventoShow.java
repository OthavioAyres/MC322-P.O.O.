package lab01;

public class EventoShow extends Evento {
    private String Artista;
    private String data;

    public EventoShow(String nome, Local local, double precoIngresso , String Artista,  String data) {
        super(nome, local, precoIngresso);
        this.Artista = Artista;
        this.data = data;
    }
    
    public void exibirDetalhes () {
         System . out . println ( " Artista : " + this.Artista ) ;
         System . out . println ( " Data : " + this.data ) ;}
}

