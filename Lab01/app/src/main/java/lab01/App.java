/*
 * App.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        EventoShow Evento_1 = new EventoShow("MPB em Campinas", local, 200, "Djavan", "01/05/2025");
        IngressoMeia ingressoMeia = new IngressoMeia(Evento_1);

        // DEMONSTRAÇÃO PASSO 2



        // DEMONSTRAÇÃO PASSO 3



        // DEMONSTRAÇÃO PASSO 4



        // DEMONSTRAÇÃO PASSO 5
    }
}
