package lab02;

import java.util.List;
import lab02.exceptions.CapacidadeInsuficienteException;
import lab02.exceptions.LocalIndisponivelException;

public class Organizadora {

    private String nome;
    private int cnpj;
    private String endereco;

    /**
     * Construtor da classe Organizadora
     * @param nome o nome da organizadora
     * @param cnpj o CNPJ da organizadora
     * @param endereco o endereço da organizadora
     */
    public Organizadora(String nome, int cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    /**
     * Retorna o nome da organizadora
     * @return o nome da organizadora
     */
    public String getNome() {
        return nome;
    }

    /**
     * Cria um evento do tipo Festival
     * @param nome o nome do Festival
     * @param local o local do Festival
     * @param precoBase o preço base do ingresso
     * @param data a data do Festival
     * @param lineup a lista de artistas do Festival
     * @param duracao a duração do Festival em dias
     * @return um novo EventoFestival
     * @throws CapacidadeInsuficienteException se o local não tiver capacidade suficiente
     * @throws LocalIndisponivelException se o local não estiver disponível
     */
    public EventoFestival criarEvento(String nome, Local local, double precoBase, String data, double quantidadeParticipantes, List<String> lineup, int duracao) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        EventoFestival festival = new EventoFestival(nome, precoBase, this, data, quantidadeParticipantes, lineup, duracao);
        local.alocarParaEvento(festival);
        return festival;
    }

    /**
     * Cria um evento do tipo Show
     * @param nome o nome do Show
     * @param local o local do Show
     * @param precoBase o preço base do ingresso
     * @param data a data do Show
     * @param artista o artista do Show
     * @return um novo EventoShow
     * @throws CapacidadeInsuficienteException se o local não tiver capacidade suficiente
     * @throws LocalIndisponivelException se o local não estiver disponível
     */
    public EventoShow criarEvento(String nome, Local local, double precoBase, String data, double quantidadeParticipantes, String artista) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        EventoShow show = new EventoShow(nome, precoBase, this, data, quantidadeParticipantes, artista);
        local.alocarParaEvento(show);
        return show;
    }

    /**
     * Cria um evento do tipo Jogo
     * @param nome o nome do Jogo
     * @param local o local do Jogo
     * @param precoBase o preço base do ingresso
     * @param data a data do Jogo
     * @param times a lista de times que jogarão
     * @return um novo EventoJogo
     * @throws CapacidadeInsuficienteException se o local não tiver capacidade suficiente
     * @throws LocalIndisponivelException se o local não estiver disponível
     */
    public EventoJogo criarEvento(String nome, Local local, double precoBase, String data, double quantidadeParticipantes, List<String> times) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        EventoJogo jogo = new EventoJogo(nome, precoBase, this, data, quantidadeParticipantes, times);
        local.alocarParaEvento(jogo);
        return jogo;
    }

    /**
     * Cria um evento do tipo Bar
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoBase o preço base do ingresso
     * @param data a data do evento
     * @param quantidadeParticipantes a quantidade de participantes do evento
     * @param nomeBar o nome do bar
     * @param inicioHappyHour o horário de início do happy hour
     * @param duracaoHappyHour a duração do happy hour
     * @return um novo EventoEmBar
     * @throws CapacidadeInsuficienteException se o local não tiver capacidade suficiente
     * @throws LocalIndisponivelException se o local não estiver disponível
     */
    public EventoEmBar criarEvento(String nome, Local local, double precoBase, String data, double quantidadeParticipantes,
                                 String nomeBar, String inicioHappyHour, String duracaoHappyHour) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        EventoEmBar eventoBar = new EventoEmBar(nome, precoBase, this, data, quantidadeParticipantes, nomeBar, inicioHappyHour, duracaoHappyHour);
        local.alocarParaEvento(eventoBar);
        return eventoBar;
    }

    /**
     * Cria um evento do tipo Música Ao Vivo
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoBase o preço base do ingresso
     * @param data a data do evento
     * @param quantidadeParticipantes a quantidade de participantes do evento
     * @param nomeArtista o nome do artista
     * @param generoMusical o gênero musical
     * @return um novo EventoMusicaAoVivo
     * @throws CapacidadeInsuficienteException se o local não tiver capacidade suficiente
     * @throws LocalIndisponivelException se o local não estiver disponível
     */
    public EventoMusicaAoVivo criarEventoMusicaAoVivo(String nome, Local local, double precoBase, String data, double quantidadeParticipantes,
                                                     String nomeArtista, String generoMusical) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        EventoMusicaAoVivo eventoMusica = new EventoMusicaAoVivo(nome, precoBase, this, data, quantidadeParticipantes, nomeArtista, generoMusical);
        local.alocarParaEvento(eventoMusica);
        return eventoMusica;
    }
}

