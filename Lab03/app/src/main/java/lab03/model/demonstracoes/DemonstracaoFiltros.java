package lab03.model.demonstracoes;

import java.util.ArrayList;
import java.util.List;

import lab03.model.exceptions.CapacidadeInsuficienteException;
import lab03.model.exceptions.LocalIndisponivelException;
import lab03.model.filter.EventoPorDataFilter;
import lab03.model.filter.EventoPorLocalFilter;
import lab03.model.filter.EventoPorNomeFilter;
import lab03.model.filter.EventoPorOrganizadoraFilter;
import lab03.model.filter.Filter;
import lab03.model.Evento;
import lab03.model.EventoJogo;
import lab03.model.EventoShow;
import lab03.model.Local;
import lab03.model.Organizadora;
import lab03.model.filter.AndFilter;
/**
 * Classe para demonstrar o uso dos filtros de eventos
 */
public class DemonstracaoFiltros {

    public static void main(String[] args) {
        // Criando organizadoras
        Organizadora organizadora1 = new Organizadora("Eventos SP", 123456789, "São Paulo");
        Organizadora organizadora2 = new Organizadora("Eventos RJ", 987654321, "Rio de Janeiro");
        
        // Criando locais
        Local localSP = new Local("Arena SP", 5000);
        Local localRS = new Local("Estádio RS", 10000);
        Local localRJ = new Local("Estádio RJ", 10000);
        Local localMG = new Local("Arena MG", 45000);
        
        // Lista para armazenar os eventos
        List<Evento> listaEventos = new ArrayList<>();
        
        try {
            // Criando eventos para a organizadora1
            EventoShow show1 = organizadora1.criarEvento(
                "Show Rock SP", 
                localSP, 
                150.0, 
                "15/06/2024", 
                1000, 
                "Banda Rock"
            );
            listaEventos.add(show1);
            
            List<String> times1 = new ArrayList<>();
            times1.add("São Paulo FC");
            times1.add("Atletico mineiro");
            EventoJogo jogo1 = organizadora1.criarEvento(
                "Final campeonatin da varzea", 
                localMG, 
                80.0, 
                "20/06/2024", 
                5000, 
                times1
            );
            listaEventos.add(jogo1);
            
            // Criando eventos para a organizadora2
            EventoShow show2 = organizadora2.criarEvento(
                "Joao Gomes RS", 
                localRS, 
                120.0, 
                "15/06/2024", 
                2000, 
                "Grupo Samba"
            );
            listaEventos.add(show2);
            
            List<String> times2 = new ArrayList<>();
            times2.add("Flamengo");
            times2.add("Fluminense");
            EventoJogo jogo2 = organizadora2.criarEvento(
                "Fla-Flu", 
                localRJ, 
                100.0, 
                "25/06/2024", 
                10000, 
                times2
            );
            listaEventos.add(jogo2);
                    
            // Pritando todos os eventos
            System.out.println("===== TODOS OS EVENTOS =====\n");
            imprimirEventos(listaEventos);
            
            // Demonstrando os filtros
            System.out.println("===== DEMONSTRAÇÃO DOS FILTROS =====\n");
            
            // 1. Filtro por nome
            System.out.println("1. Filtrando eventos que contêm 'Rock' no nome:");
            Filter filtroNome = new EventoPorNomeFilter("Rock");
            List<Evento> eventosPorNome = filtroNome.filter(listaEventos);
            imprimirEventos(eventosPorNome);
            
            // 2. Filtro por data
            System.out.println("\n2. Filtrando eventos na data '15/06/2024':");
            Filter filtroData = new EventoPorDataFilter("15/06/2024");
            List<Evento> eventosPorData = filtroData.filter(listaEventos);
            imprimirEventos(eventosPorData);
            
            // 3. Filtro por local
            System.out.println("\n3. Filtrando eventos no local 'Arena SP':");
            Filter filtroLocal = new EventoPorLocalFilter("Arena SP");
            List<Evento> eventosPorLocal = filtroLocal.filter(listaEventos);
            imprimirEventos(eventosPorLocal);
            
            // 4. Filtro por organizadora
            System.out.println("\n4. Filtrando eventos da organizadora 'Eventos RJ':");
            Filter filtroOrganizadora = new EventoPorOrganizadoraFilter("Eventos RJ");
            List<Evento> eventosPorOrganizadora = filtroOrganizadora.filter(listaEventos);
            imprimirEventos(eventosPorOrganizadora);
            
            // 5. Usando o CompositeFilter para combinar filtros
            System.out.println("\n6. Usando AndFilter: eventos na data '15/06/2024' E da organizadora 'Eventos RJ':");
            List<Filter> listaFiltros = new ArrayList<>();
            listaFiltros.add(new EventoPorDataFilter("15/06/2024"));
            listaFiltros.add(new EventoPorOrganizadoraFilter("Eventos RJ"));
            
            Filter filtroComposto = new AndFilter(listaFiltros);
            List<Evento> eventosFiltroCombinado = filtroComposto.filter(listaEventos);
            imprimirEventos(eventosFiltroCombinado);
            
        } catch (CapacidadeInsuficienteException | LocalIndisponivelException e) {
            System.out.println("Erro ao criar eventos: " + e.getMessage());
        }
    }
    
    /**
     * Método auxiliar para imprimir informações dos eventos
     * @param eventos lista de eventos a serem impressos
     */
    private static void imprimirEventos(List<Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("  Nenhum evento encontrado!");
            return;
        }
        
        for (Evento evento : eventos) {
            System.out.println("  - " + evento.getNome() + 
                             " (Local: " + evento.getLocal().getNome() + 
                             ", Data: " + evento.getData() + 
                             ", Organizadora: " + evento.getOrganizadora().getNome() + ")");
        }
    }
}