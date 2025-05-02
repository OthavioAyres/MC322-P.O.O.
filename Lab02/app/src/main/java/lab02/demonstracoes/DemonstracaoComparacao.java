package lab02.demonstracoes;

import lab02.Cliente;
import lab02.Evento;
import lab02.EventoShow;  // Importando a classe concreta EventoShow
import lab02.Ingresso;
import lab02.Organizadora;

public class DemonstracaoComparacao {
    public static void main(String[] args) {
        // Cenário 1: Dois clientes com ingressos para o mesmo evento
        System.out.println("Cenário 1: Clientes com ingressos para o mesmo evento");
        Evento eventoComum = new EventoShow("Concerto de Rock", 50.0, null, "2023-10-01", 100, "Banda XYZ");  // Usando EventoShow em vez de Evento
        Cliente cliente1 = new Cliente("João", "joao@email.com");
        Cliente cliente2 = new Cliente("Maria", "maria@email.com");
        
        Ingresso ingresso1 = new Ingresso(eventoComum, 50.0);  // Cria um ingresso para o evento comum
        Ingresso ingresso2 = new Ingresso(eventoComum, 50.0);  // Outro ingresso para o mesmo evento
        
        cliente1.adicionarIngresso(ingresso1);
        cliente2.adicionarIngresso(ingresso2);
        
        int resultado1 = cliente1.compareTo(cliente2);
        System.out.println("Resultado da comparação: " + (resultado1 == 0 ? "Eles possuem ingressos para o mesmo evento." : "Eles não possuem ingressos para o mesmo evento."));
        
        // Cenário 2: Dois clientes sem ingressos para o mesmo evento
        System.out.println("\nCenário 2: Clientes sem ingressos para o mesmo evento");
        Evento eventoDiferente = new EventoShow("Festival de Jazz", 60.0, null, "2023-11-01", 150, "Músico ABC");  // Usando EventoShow em vez de Evento
        Cliente cliente3 = new Cliente("Pedro", "pedro@email.com");
        Cliente cliente4 = new Cliente("Ana", "ana@email.com");
        
        Ingresso ingresso3 = new Ingresso(eventoDiferente, 60.0);  // Ingresso para evento diferente
        cliente3.adicionarIngresso(ingresso3);  // cliente3 tem ingresso para eventoDiferente
        // cliente4 não tem nenhum ingresso
        
        int resultado2 = cliente3.compareTo(cliente4);
        System.out.println("Resultado da comparação: " + (resultado2 == 0 ? "Eles possuem ingressos para o mesmo evento." : "Eles não possuem ingressos para o mesmo evento."));
    }
} 