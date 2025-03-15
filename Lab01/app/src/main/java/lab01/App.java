/*
 * App.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

import org.checkerframework.checker.units.qual.s;

// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.w3c.dom.events.Event;

/**
 * Contém a estrutura de implementação da aplicação.
 * 
 * @author Gabriel Leite - 216180
 * @author Caio Rhoden - 214129
 */
public class App {

    /**
     * Aplicação principal
     * @param args
     */
    public static void main(String[] args) {


        // DEMONSTRAÇÃO CÓDIGO PRELIMINAR
        
        Local local = new Local("Allianz Parque", 300);
        Usuario usuario = new Usuario("Gabriel", "gabriel@gmail.com");

        // Dados sobre evento
        System.out.println("Local: " + local.getNome());
        System.out.println("Nome do usuário: " + usuario.getNome());

        // DEMONSTRAÇÃO PASSO 1
        System.out.println("DEMONSTRAÇÃO PASSO 1");
        EventoShow Evento_Show = new EventoShow("MPB em Campinas", local, 100.50, "Natiruts", "09/04/2003");

        IngressoInteira ingressoInteiro = new IngressoInteira(Evento_Show);
        IngressoMeia ingressoMeia = new IngressoMeia(Evento_Show);
        IngressoVIP ingressoVip = new IngressoVIP(Evento_Show);
        IngressoPCD IngressoPCD = new IngressoPCD(Evento_Show);

        System.out.println(" Preço do ingresso Inteiro: " + ingressoInteiro.getPreco());
        System.out.println(" Preço do ingresso Meia: " + ingressoMeia.getPreco());
        System.out.println(" Preço do ingresso Vip: " + ingressoVip.getPreco());
        System.out.println(" Preço do ingresso PCD: " + IngressoPCD.getPreco());

        // DEMONSTRAÇÃO PASSO 2
        System.out.println("DEMONSTRAÇÃO PASSO 2");
        Evento_Show.exibirDetalhes();



        // DEMONSTRAÇÃO PASSO 3
        System.out.println("DEMONSTRAÇÃO PASSO 3");
        System.out.println(" Ingresso do usuário: " + usuario.getIngresso());
        System.out.println(" Lista de ingresso: " + Evento_Show.getIngressosVendidos().size());
        Evento_Show.adicionarIngresso(ingressoInteiro,usuario);
        System.out.println(" Ingresso do usuário: " + usuario.getIngresso().getPreco());
        Usuario usuario_2 = new Usuario("Oth", "Oth@gmail.com");
        Evento_Show.adicionarIngresso(ingressoVip,usuario_2);
        System.out.println(" Lista de ingresso: " + Evento_Show.getIngressosVendidos().size());
        System.out.println(" Faturamento do Evento:" + Evento_Show.calcularFaturamento());
        // DEMONSTRAÇÃO PASSO 4



        // DEMONSTRAÇÃO PASSO 5
    }
}
