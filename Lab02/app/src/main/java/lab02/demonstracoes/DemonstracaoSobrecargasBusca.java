package lab02.demonstracoes;

import java.util.ArrayList;
import java.util.List;
import lab02.ImobiliariaDeEventos;
import lab02.Local;

/**
 * Classe para demonstrar a utilização das sobrecargas dos métodos de busca
 */
public class DemonstracaoSobrecargasBusca {

    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DAS SOBRECARGAS DOS MÉTODOS DE BUSCA ===\n");
        
        // Criando uma imobiliária de eventos
        ImobiliariaDeEventos imobiliaria = new ImobiliariaDeEventos("Imobiliária de Eventos SP");
        
        // Inicializando a lista de locais
        List<Local> locais = new ArrayList<>();
        
        // Criando locais para teste
        Local local1 = new Local("Teatro Municipal", 500);
        Local local2 = new Local("Estádio do Morumbi", 65000);
        Local local3 = new Local("Casa de Shows", 1000);
        Local local4 = new Local("Clube Esportivo", 500);

        // Adicionando locais à lista
        locais.add(local1);
        locais.add(local2);
        locais.add(local3);
        locais.add(local4);
        
        // Método sobrecarregado para inicializar a imobiliária com uma lista de locais
        imobiliaria.setLocais(locais);
        
        // 1. Testando busca por nome (primeira sobrecarga)
        System.out.println("1. Busca por nome exato:");
        Local localEncontrado1 = imobiliaria.buscarLocal("Estádio do Morumbi");
        if (localEncontrado1 != null) {
            System.out.println("   Local encontrado: " + localEncontrado1.getNome() + " - Capacidade: " + localEncontrado1.getCapacidade());
        } else {
            System.out.println("   Local 'Estádio do Morumbi' não encontrado.");
        }
        
        // 2. Testando busca por capacidade (segunda sobrecarga)
        System.out.println("\n2. Busca por capacidade exata:");
        Local localEncontrado2 = imobiliaria.buscarLocal(500);
        if (localEncontrado2 != null) {
            System.out.println("   Local encontrado com capacidade 500: " + localEncontrado2.getNome());
        } else {
            System.out.println("   Local com capacidade 500 não encontrado.");
        }
        
        // 3. Testando busca por nome inexistente
        System.out.println("\n3. Busca por nome inexistente:");
        Local localEncontrado3 = imobiliaria.buscarLocal("Arena Inexistente");
        if (localEncontrado3 != null) {
            System.out.println("   Local encontrado: " + localEncontrado3.getNome());
        } else {
            System.out.println("   Local 'Arena Inexistente' não encontrado.");
        }
        
        // 4. Testando busca por capacidade inexistente
        System.out.println("\n4. Busca por capacidade inexistente:");
        Local localEncontrado4 = imobiliaria.buscarLocal(123);
        if (localEncontrado4 != null) {
            System.out.println("   Local encontrado com capacidade 123: " + localEncontrado4.getNome());
        } else {
            System.out.println("   Local com capacidade 123 não encontrado.");
        }
    }
} 