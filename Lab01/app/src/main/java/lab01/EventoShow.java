package lab01;

public class EventoShow extends Evento {
    private int duracao;
    private String generoMusical;
    private String data;

    public EventoShow(String nome, Local local, double precoIngresso , int duracao, String generoMusical,  String data) {
        super(nome, local, precoIngresso);
        this.duracao = duracao;
        this.generoMusical = generoMusical;
        this.data = data;
    }
    
    public void exibirDetalhes () {
         System . out . println ( " Duracaoo do show : " + this.duracao + " minutos " ) ;
         System . out . println ( " Genero musical : " + this.generoMusical ) ;
         System . out . println ( " Data : " + this.data ) ;}
}
