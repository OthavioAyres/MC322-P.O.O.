package lab01;

public class IngressoPCD extends Ingresso{
    public IngressoPCD(Evento evento){
        super(evento);
    }
    @Override
    public double getPreco() {
        return this.getEvento().getPrecoIngresso()/5 ; 
    }
}