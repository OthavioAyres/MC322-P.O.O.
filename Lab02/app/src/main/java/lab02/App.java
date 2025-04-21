/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.ArrayList;
import java.util.List;
import lab02.exceptions.CapacidadeInsuficienteException;
import lab02.exceptions.LocalIndisponivelException;
import lab02.exceptions.IngressoEsgotadoException;
import lab02.exceptions.IngressoNaoEncontradoException;
import lab02.exceptions.CancelamentoNaoPermitidoException;
import lab02.exceptions.EventoNaoEncontradoException;

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
        // 1 - Criação de objetos utilizando as sobrecargas.
        Organizadora organizadora = criacao_objetos_utilizando_sobrecarga();
        
        // Criando clientes
        Cliente cliente1 = new Cliente("Othavio", "tata@email.com");
        Cliente cliente2 = new Cliente("Henrique", "heheque@email.com");
        
        // 2 - Demonstração de alocação de locais com tratamento de exceções
        demonstrarAlocacaoLocais();
        
        // 3 - Demonstração de venda de ingressos com tratamento de exceções
        demonstrarVendaIngressos(organizadora, cliente1, cliente2);
        
        // 4 - Demonstração de cancelamento de ingressos com tratamento de exceções
        demonstrarCancelamentoIngressos(cliente1, cliente2);
    }

    /**
     * Demonstra a alocação de locais com tratamento de exceções
     */
    public static void demonstrarAlocacaoLocais() {
        System.out.println("\n=== Demonstração de Alocação de Locais ===");
        
        // Criando locais
        Local localTeatro = new Local("Teatro Pequeno", 1);
        Local localEstadio = new Local("Estádio Municipal", 10000);
        
        // Criando organizadora
        Organizadora organizadora = new Organizadora("Eventos Teste", 987654321, "Rua Teste, 123");
        
        // Tentando alocar eventos em locais com capacidade insuficiente
        try {
            // Criando evento com muitos participantes para o teatro pequeno
            EventoShow showGrande = organizadora.criarEvento(
                "Show Grande",
                localTeatro,
                200.0,
                "01/05/2024",
                5,
                "Banda Famosa"
            );

            
        } catch (CapacidadeInsuficienteException e) {
            System.out.println("Erro ao alocar local: " + e.getMessage());
        } catch (LocalIndisponivelException e) {
            System.out.println("Erro ao alocar local: " + e.getMessage());
        }
        
        // Tentando alocar dois eventos no mesmo local
        try {
            // Criando dois eventos para o mesmo local
            EventoShow show1 = organizadora.criarEvento(
                "Show 1",
                localEstadio,
                100.0,
                "10/05/2024",
                5,
                "Artista 1"
            );
            
            EventoShow show2 = organizadora.criarEvento(
                "Show 2",
                localEstadio,
                120.0,
                "11/05/2024",
                5,
                "Artista 2"
                
            );
            
            System.out.println("Evento '" + show1.getNome() + "' alocado com sucesso no local '" + localEstadio.getNome() + "'");
    
            
        } catch (CapacidadeInsuficienteException e) {
            System.out.println("Erro ao alocar local: " + e.getMessage());
        } catch (LocalIndisponivelException e) {
            System.out.println("Erro ao alocar local: " + e.getMessage());
        }
    }
    
    /**
     * Demonstra a venda de ingressos com tratamento de exceções
     */
    public static void demonstrarVendaIngressos(Organizadora organizadora, Cliente cliente1, Cliente cliente2) {
        System.out.println("\n=== Demonstração de Venda de Ingressos ===");
        
        // Criando local com capacidade limitada
        Local localPequeno = new Local("Sala de Show", 2);
        
        try {
            // Criando evento com capacidade muito limitada
            EventoShow showPequeno = organizadora.criarEvento(
                "Show Exclusivo",
                localPequeno,
                500.0,
                "20/05/2024",
                2,
                "Artista Exclusivo"
            );

            
            // Vendendo ingressos até esgotar
            System.out.println("Tentando vender ingressos para o evento: " + showPequeno.getNome());
            
            // Venda para cliente1 (deve funcionar)
            showPequeno.venderIngresso(cliente1);
            System.out.println("Ingresso vendido para " + cliente1.getNome());
            
            // Venda para cliente2 (deve funcionar)
            showPequeno.venderIngresso(cliente2);
            System.out.println("Ingresso vendido para " + cliente2.getNome());
            
            // Tentando vender mais um ingresso (deve falhar)
            Cliente cliente3 = new Cliente("Carlos", "carlos@email.com");
            showPequeno.venderIngresso(cliente3);
            
        } catch (IngressoEsgotadoException e) {
            System.out.println("Erro ao vender ingresso: " + e.getMessage());
        } catch (EventoNaoEncontradoException e) {
            System.out.println("Erro ao vender ingresso: " + e.getMessage());
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("Erro ao alocar local: " + e.getMessage());
        }
    }
    
    /**
     * Demonstra o cancelamento de ingressos com tratamento de exceções
     */
    public static void demonstrarCancelamentoIngressos(Cliente cliente1, Cliente cliente2) {
        System.out.println("\n=== Demonstração de Cancelamento de Ingressos ===");
        
        // Criando organizadora e local para testes
        Organizadora organizadora = new Organizadora("Eventos Cancelamento", 111222333, "pindamonhangaba");
        Local local = new Local("Arena", 1000);
        
        try {
            // Criando evento para teste de cancelamento
            EventoShow show = organizadora.criarEvento(
                "Show Cancelável",
                local,
                150.0,
                "30/05/2024",
                5,
                "Artista Teste"
            );

            // Vendendo ingresso para cliente1
            show.venderIngresso(cliente1);
            System.out.println("Ingresso vendido para " + cliente1.getNome());
            
            // Cancelando o ingresso (deve funcionar)
            cliente1.cancelarIngresso(show);
            System.out.println("Ingresso cancelado com sucesso para " + cliente1.getNome());
            
            // Tentando cancelar novamente (deve falhar - ingresso não encontrado)
            cliente1.cancelarIngresso(show);
            
        } catch (IngressoNaoEncontradoException e) {
            System.out.println("Erro ao cancelar ingresso: " + e.getMessage());
        } catch (CancelamentoNaoPermitidoException e) {
            System.out.println("Erro ao cancelar ingresso: " + e.getMessage());
        } catch (IngressoEsgotadoException | EventoNaoEncontradoException | CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        // Testando cancelamento não permitido
        try {
            // Criando evento gratuito
            EventoFestival eventoGratuito = criarEventoGratuito(organizadora, local);
            
            // Vendendo ingresso gratuito para cliente2
            eventoGratuito.venderIngresso(cliente2);
            System.out.println("Ingresso gratuito vendido para " + cliente2.getNome());
            
            // Tentando cancelar ingresso gratuito (deve falhar - cancelamento não permitido)
            cliente2.cancelarIngresso(eventoGratuito);
            
        } catch (IngressoNaoEncontradoException e) {
            System.out.println("Erro ao cancelar ingresso: " + e.getMessage());
        } catch (CancelamentoNaoPermitidoException e) {
            System.out.println("Erro ao cancelar ingresso: " + e.getMessage());
        } catch (IngressoEsgotadoException | EventoNaoEncontradoException | CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    /**
     * Cria um evento gratuito para testes
     */
    private static EventoFestival criarEventoGratuito(Organizadora organizadora, Local local) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        List<String> lineup = new ArrayList<>();
        lineup.add("Artista 1");
        lineup.add("Artista 2");
        
        EventoFestival festival = organizadora.criarEvento(
            "Festival Gratuito",
            local,
            0.0,  // Preço zero
            "01/06/2024",
            5,
            lineup,
            1
        );

        
        return festival;
    }

    public static Organizadora criacao_objetos_utilizando_sobrecarga() {
        // Criando uma organizadora
        Organizadora organizadora = new Organizadora("Eventos Inc.", 123456789, "Rua dos Eventos, 123");

        // Criando locais
        Local localShow = new Local("Teatro Municipal De Campinas", 1000);
        Local localJogo = new Local("Estádio Do São Paulo", 50000);
        Local localFestival = new Local("Taquaral", 20000);

        try {
            // Criando um Show
            EventoShow show = organizadora.criarEvento(
                "Show de funk",
                localShow,
                150.0,
                "15/04/2024",
                5,
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
                5,
                times
            );
            
            // Criando um Festival
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
            


            // Exibindo as descrições dos eventos
            System.out.println("=== Descrições dos Eventos ===");
            System.out.println(show.descricao());
            System.out.println(jogo.descricao());
            System.out.println(festival.descricao());
            
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("Erro ao alocar local: " + e.getMessage());
        }

        return organizadora;
    }
}
