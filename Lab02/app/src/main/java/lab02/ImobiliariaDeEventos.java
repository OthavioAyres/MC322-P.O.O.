/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.util.List;

public class ImobiliariaDeEventos {
    
    private List<Local> locais;
    private String nome;


    /**
     * Construtor da classe ImobiliariaDeEventos
     * @param nome o nome da imobiliária de eventos
     */
    public ImobiliariaDeEventos(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona um local à lista de locais disponíveis
     * @param local o local a ser adicionado
     */
    public void adicionarLocal(Local local) {
        this.locais.add(local);
    }

    /**
     * Busca um local pelo seu nome
     * @param nome o nome do local a ser buscado
     * @return o local encontrado ou null se não encontrar
     */
    public Local buscarLocal(String nome) {
        for (Local local : locais) {
            if (local.getNome().equals(nome)) {
                return local;
            }
        }
        return null;
    }

    /**
     * Busca um local pela sua capacidade máxima
     * @param capacidadeMaxima a capacidade máxima do local a ser buscado
     * @return o local encontrado ou null se não encontrar
     */
    public Local buscarLocal(int capacidadeMaxima) {
        for (Local local : locais) {
            if (local.getCapacidade() == capacidadeMaxima) {
                return local;
            }
        }
        return null;
    }
    
}
