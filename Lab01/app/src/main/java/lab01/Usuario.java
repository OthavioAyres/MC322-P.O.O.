/*
 * Usuario.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab01;

/**
 * Contém a estrutura de implementação de um Usuario.
 * 
 * @Othavio Henrique de Jesus Ayres - 246666
 */
public class Usuario {

    private String nome;
    private String email;
    private Ingresso ingresso;
    

    /**
     * Construtor da classe Usuario
     * @param nome o nome do usuário
     * @param email o email do usuário
     */
    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.ingresso = null;
    }

    /**
     * Retorna o nome do usuário
     * @return o nome do usupario
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do usuário para `nome` 
     * @param nome o novo nome do usuário
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    /**
     * Retorna o Ingresso do usuário
     * @return o Ingresso do usupario
     */
    public Ingresso getIngresso(){
        return ingresso;
    }
    /**
     * Altera o Ingresso do usuário para `Ingresso` 
     * @param Ingresso o novo Ingresso do usuário
     */
    public void setIngresso(Ingresso ingresso){
        this.ingresso = ingresso;
    }
}
