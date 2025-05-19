package lab03;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import lab03.model.*;
import lab03.model.caracteristica.*;

import java.io.IOException;

public class EventoDetalhesController {
    @FXML
    private Label labelTituloEvento;
    
    @FXML
    private Label labelData;
    
    @FXML
    private Label labelLocal;
    
    @FXML
    private Label labelPreco;
    
    @FXML
    private Label labelOrganizadora;
    
    @FXML
    private Label labelCapacidade;
    
    @FXML
    private Label labelIngressosVendidos;
    
    @FXML
    private Label labelDetalhes;
    
    private Evento evento;
    private String telaAnterior;
    
    public void setEvento(Evento evento) {
        this.evento = evento;
        preencherDetalhes();
    }
    
    public void setTelaAnterior(String telaAnterior) {
        this.telaAnterior = telaAnterior;
    }
    
    private void preencherDetalhes() {
        if (evento == null) {
            return;
        }
        
        // Preencher os dados básicos do evento
        labelTituloEvento.setText(evento.getNome());
        labelData.setText(evento.getData());
        
        // Verificar se o evento tem local definido
        if (evento.getLocal() != null) {
            labelLocal.setText(evento.getLocal().getNome());
        } else {
            labelLocal.setText("Local não definido");
        }
        
        labelPreco.setText(String.format("R$ %.2f", evento.getPrecoIngresso()));
        
        // Verificar se o evento tem organizadora definida
        if (evento.getOrganizadora() != null) {
            labelOrganizadora.setText(evento.getOrganizadora().getNome());
        } else {
            labelOrganizadora.setText("Organizadora não definida");
        }
        
        labelCapacidade.setText(String.format("%.0f pessoas", evento.getQuantidadeParticipantes()));

        // Verificar o tipo específico de evento para mostrar detalhes adicionais
        String detalhesEspecificos = "";
        
        if (evento instanceof EventoShow) {
            EventoShow eventoShow = (EventoShow) evento;
            detalhesEspecificos = "Tipo: Show - Artista: " + eventoShow.getArtista();
        } else if (evento instanceof EventoFestival) {
            EventoFestival eventoFestival = (EventoFestival) evento;
            detalhesEspecificos = "Tipo: Festival - Duração: " + eventoFestival.getDuracao() + " dias";
        } else if (evento instanceof EventoJogo) {
            EventoJogo eventoJogo = (EventoJogo) evento;
            detalhesEspecificos = "Tipo: Jogo - Times: " + eventoJogo.getTimes();
        } else if (evento instanceof EventoMusicaAoVivo) {
            EventoMusicaAoVivo eventoMusica = (EventoMusicaAoVivo) evento;
            detalhesEspecificos = "Tipo: Música ao Vivo - Artista: " + eventoMusica.getNomeArtista() + 
                " - Gênero: " + eventoMusica.getGeneroMusical();
        } else if (evento instanceof EventoEmBar) {
            EventoEmBar eventoBar = (EventoEmBar) evento;
            detalhesEspecificos = "Tipo: Evento em Bar - Bar: " + eventoBar.getNomeBar();
        } else {
            detalhesEspecificos = "Tipo: Evento Genérico";
        }
        
        labelDetalhes.setText(detalhesEspecificos);
    }
    
    @FXML
    private void onVoltar(ActionEvent event) throws IOException {
        // Determinar para qual tela voltar
        String resourcePath = "/part4_dashboard.fxml";
        if (telaAnterior != null) {
            switch (telaAnterior) {
                case "marketplace":
                    resourcePath = "/marketplace.fxml";
                    break;
                case "ingressos":
                    resourcePath = "/lista_ingressos.fxml";
                    break;
                default:
                    resourcePath = "/part4_dashboard.fxml";
            }
        }
        
        // Voltar para a tela anterior
        Parent telaAnteriorParent = FXMLLoader.load(getClass().getResource(resourcePath));
        Scene telaAnteriorScene = new Scene(telaAnteriorParent, 800, 600);
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(telaAnteriorScene);
        
        // Definir título apropriado
        if (telaAnterior != null) {
            switch (telaAnterior) {
                case "marketplace":
                    stage.setTitle("Marketplace de Ingressos");
                    break;
                case "ingressos":
                    stage.setTitle("Meus Ingressos");
                    break;
                default:
                    stage.setTitle("Dashboard");
            }
        } else {
            stage.setTitle("Dashboard");
        }
    }
} 