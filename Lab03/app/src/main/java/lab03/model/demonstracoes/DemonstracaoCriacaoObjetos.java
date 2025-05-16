package lab03.model.demonstracoes;

import java.util.ArrayList;
import java.util.List;
import lab03.model.exceptions.CapacidadeInsuficienteException;
import lab03.model.exceptions.LocalIndisponivelException;
import lab03.model.EventoFestival;
import lab03.model.EventoJogo;
import lab03.model.EventoShow;
import lab03.model.Local;
import lab03.model.Organizadora;

/**
 * Classe para demonstrar a criação de objetos utilizando sobrecargas
 */
public class DemonstracaoCriacaoObjetos {

    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DE CRIAÇÃO DE OBJETOS UTILIZANDO SOBRECARGAS ===\n");
        
        // Criando uma organizadora
        Organizadora organizadora = new Organizadora("Eventos Inc.", 123456789, "Rua dos Eventos, 123");
        System.out.println("Organizadora criada: " + organizadora.getNome());

        // Criando locais
        Local localShow = new Local("Teatro Municipal De Campinas", 1000);
        Local localJogo = new Local("Estádio Do São Paulo", 50000);
        Local localFestival = new Local("Taquaral", 20000);
        
        System.out.println("\nLocais criados:");
        System.out.println("1. " + localShow.getNome() + " - Capacidade: " + localShow.getCapacidade());
        System.out.println("2. " + localJogo.getNome() + " - Capacidade: " + localJogo.getCapacidade());
        System.out.println("3. " + localFestival.getNome() + " - Capacidade: " + localFestival.getCapacidade());

        try {
            System.out.println("\nCriando diferentes tipos de eventos usando sobrecargas:");
            
            // Criando um Show (primeira sobrecarga)
            System.out.println("\n1. Criando EventoShow:");
            EventoShow show = organizadora.criarEvento(
                "Show de funk",
                localShow,
                150.0,
                "15/04/2024",
                5,
                "MC ORUAN"
            );
            System.out.println("   " + show.descricao());

            // Criando um Jogo (segunda sobrecarga)
            System.out.println("\n2. Criando EventoJogo:");
            List<String> times = new ArrayList<>();
            times.add("SAO PAULO");
            times.add("Palmeiras");
            EventoJogo jogo = organizadora.criarEvento(
                "final da copinha",
                localJogo,
                80.0,
                "20/04/2024",
                5,
                times
            );
            System.out.println("   " + jogo.descricao());
            
            // Criando um Festival (terceira sobrecarga)
            System.out.println("\n3. Criando EventoFestival:");
            List<String> lineup = new ArrayList<>();
            lineup.add("queen");
            lineup.add("Cazuza");
            EventoFestival festival = organizadora.criarEvento(
                "Aniversario da cidade de Campinas",
                localFestival,
                300.0,
                "25/04/2024",
                5,
                lineup,
                3
            );
            System.out.println("   " + festival.descricao());
            
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("Erro ao criar evento: " + e.getMessage());
        }
    }
} 