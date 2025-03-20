package lab01;

import java.util.List;

public class EventoTeatro extends Evento implements FiltroEvento{
    private String peca;
    private List<String> atores;
    private String data;

    public EventoTeatro(String nome, Local local, double precoIngresso, String peca, List<String> atores, String data) {
        super(nome, local, precoIngresso);
        this.peca = peca;
        this.atores = atores;
        this.data = data;
    }
    
    public void propaganda () {
         System . out . println ( "Estrelaremos a peça " + this.peca ) ;
         System . out . println ( "Com a brilhante atuação de" + this.atores ) ;
         System . out . println ( "Imperdivel!!! Corra para comprar nossos ingressos disponiveis até:" + this.data ) ;
        }

    @Override
    /**
     * Compara a peca do teatro com a peca do outro teatro
     * e retorna true para caos sejam iguais e false caso contrário
     */
    public boolean filtrar(Evento evento) {
        if (evento instanceof EventoTeatro) {
            EventoTeatro outroTeatro = ( EventoTeatro ) evento ;
            if (this.peca.equals(outroTeatro.peca ) ) {
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
    public void setPeca(String peca) {
        this.peca = peca;
    }

    public String getPeca() {
        return peca;
    }

    public void setAtores(List<String> atores) {
        this.atores = atores;
    }

    public List<String> getAtores() {
        return atores;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

