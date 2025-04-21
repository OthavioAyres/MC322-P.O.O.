/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação da aplicação.
 * 
 * @author NOME - RA
 */
public class App {

    /**
     * Aplicação principal
     * @param args
     */
    public static void main(String[] args) {
        // Criando uma organizadora
        Organizadora organizadora = new Organizadora("Eventos Inc.", 123456789, "Rua dos Eventos, 123");

        // Criando locais
        Local localShow = new Local("Teatro Municipal De Campinas", 1000);
        Local localJogo = new Local("Estádio Do São Paulo", 50000);
        Local localFestival = new Local("Taquaral", 20000);

        // Criando um Show
        EventoShow show = organizadora.criarEvento(
            "Show de funk",
            localShow,
            150.0,
            "15/04/2024",
            "MC ORUAN"
        );

        // Criando um Jogo
        List<String> times = new ArrayList<>();
        times.add("SAO PAULO");
        times.add("Palmeiras");
        EventoJogo jogo = organizadora.criarEvento(
            "final da copinha",
            localJogo,
            80.0,
            "20/04/2024",
            times
        );

        // Criando um Festival
        List<String> lineup = new ArrayList<>();
        lineup.add("queen");
        lineup.add("Cazuza");
        EventoFestival festival = new EventoFestival(
            "Aniversario da cidade de Campinas",
            localFestival,
            300.0,
            organizadora,
            "25/04/2024",
            lineup,
            3
        );

        // Exibindo as descrições dos eventos
        System.out.println("=== Descrições dos Eventos ===");
        System.out.println(show.getDescricao());
        System.out.println(jogo.descricao());
        System.out.println(festival.descricao());
    }
}
