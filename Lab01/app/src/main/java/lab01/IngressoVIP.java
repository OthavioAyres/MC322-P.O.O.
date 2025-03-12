package lab01;

public class IngressoVIP extends Ingresso {
    @Override
    public double getPreco() {
        return this.getEvento().getPrecoIngresso()*2; 
    }
}
