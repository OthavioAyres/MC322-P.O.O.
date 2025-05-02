package lab02;

/**
 * Classe para representar um e-mail e enviar notificações.
 */
public class Email implements Notificavel {
    private String endereco;
    
    /**
     * Construtor da classe Email
     * @param endereco o endereço de email
     */
    public Email(String endereco) {
        this.endereco = endereco;
    }
    
    /**
     * Retorna o endereço de email
     * @return o endereço de email
     */
    public String getEndereco() {
        return endereco;
    }
    
    /**
     * Define o endereço de email
     * @param endereco o novo endereço de email
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    /**
     * Exibe uma notificação na tela
     * @param assunto o assunto da notificação
     * @param mensagem o conteúdo da notificação
     */
    @Override
    public void exibirNotificacao(String assunto, String mensagem) {
        System.out.println("==== NOTIFICAÇÃO POR EMAIL ====");
        System.out.println("Para: " + endereco);
        System.out.println("Assunto: " + assunto);
        System.out.println("Mensagem: " + mensagem);
        System.out.println("===============================");
    }
} 