/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03.model;

import lab03.model.demonstracoes.DemonstracaoCriacaoObjetos;
import lab03.model.demonstracoes.DemonstracaoAlocacaoLocais;
import lab03.model.demonstracoes.DemonstracaoVendaIngressos;
import lab03.model.demonstracoes.DemonstracaoCancelamentoIngressos;
import lab03.model.demonstracoes.DemonstracaoSobrecargasBusca;
import lab03.model.demonstracoes.DemonstracaoFiltros;
import lab03.model.demonstracoes.DemonstracaoNotificacoes;
import lab03.model.demonstracoes.DemonstracaoComparacao;
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
