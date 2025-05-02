/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import lab02.demonstracoes.DemonstracaoCriacaoObjetos;
import lab02.demonstracoes.DemonstracaoAlocacaoLocais;
import lab02.demonstracoes.DemonstracaoVendaIngressos;
import lab02.demonstracoes.DemonstracaoCancelamentoIngressos;
import lab02.demonstracoes.DemonstracaoSobrecargasBusca;
import lab02.demonstracoes.DemonstracaoFiltros;
import lab02.demonstracoes.DemonstracaoNotificacoes;
import lab02.demonstracoes.DemonstracaoComparacao;
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
        // // 1 - Demonstração de criação de objetos utilizando sobrecargas
        System.out.println("\n\n");
        DemonstracaoCriacaoObjetos.main(args);
        
        // 2 - Demonstração de alocação de locais com tratamento de exceções
        System.out.println("\n\n");
        DemonstracaoAlocacaoLocais.main(args);
        
        // 3 - Demonstração de venda de ingressos com tratamento de exceções
        System.out.println("\n\n");
        DemonstracaoVendaIngressos.main(args);
        
        // 4 - Demonstração de cancelamento de ingressos com tratamento de exceções
        System.out.println("\n\n");
        DemonstracaoCancelamentoIngressos.main(args);
        
        // 5 - Demonstração das sobrecargas dos métodos de busca
        System.out.println("\n\n");
        DemonstracaoSobrecargasBusca.main(args);
        
        // 6 - Demonstração dos filtros de eventos
        System.out.println("\n\n");
        DemonstracaoFiltros.main(args);
        
        // 7 - Demonstração das notificações por email
        System.out.println("\n\n");
        DemonstracaoNotificacoes.main(args);
        
        // 8 - Demonstração da comparação de clientes
        System.out.println("\n\n");
        DemonstracaoComparacao.main(args);
    }
}
