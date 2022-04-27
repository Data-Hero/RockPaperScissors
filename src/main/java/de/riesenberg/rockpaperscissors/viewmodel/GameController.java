package de.riesenberg.rockpaperscissors.viewmodel;

import de.riesenberg.rockpaperscissors.RSPApplication;
import de.riesenberg.rockpaperscissors.model.GameModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GameController {


    @FXML
    public Label countdownLabel;
    @FXML
    public Button nextRound;
    @FXML
    public Button leave;
    @FXML
    public Button rock;
    @FXML
    public Button paper;
    @FXML
    public Button scissor;

    @FXML
    AnchorPane mainWindow;


    private GameModel game;


    @FXML
    private void initialize() {
        countdownLabel.setText("Scheere");
        rock.setVisible(false);
        paper.setVisible(false);
        scissor.setVisible(false);
        this.game = new GameModel();
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }


    @FXML
    protected void onLeave() {
        Stage labelStage = (Stage) mainWindow.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(RSPApplication.class.getResource("welcome-view.fxml"));
        try {
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            labelStage.setScene(new Scene(fxmlLoader.load(), bounds.getWidth()-10,bounds.getHeight()-30 ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onStartRound() {
        rock.setVisible(true);
        paper.setVisible(true);
        scissor.setVisible(true);
        nextRound.setVisible(false);
        leave.setVisible(false);

        this.runCountdown();
    }

    private void runCountdown() {
        Timeline timeline =
                new Timeline(new KeyFrame(Duration.millis(1000),
                        e -> {
                    String decreased = decrease(countdownLabel.getText());
                    countdownLabel.setText(decreased);
                }));
        timeline.setCycleCount(5);
        timeline.play();
    }

    private String decrease(String value) {
        return switch (value) {
            case "5" -> "4";
            case "4" -> "Scheere";
            case "Scheere" -> "Stein";
            case "Stein" -> "Papier";
            default -> "Resultat";
        };
    }

}