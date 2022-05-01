package de.riesenberg.rockpaperscissors.view;

import de.riesenberg.rockpaperscissors.RSPApplication;
import de.riesenberg.rockpaperscissors.viewmodel.GameViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView {
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
    public SplitPane splitPane;

    @FXML
    private AnchorPane mainWindow;

    private GameViewModel gameViewModel;


    @FXML
    private void initialize() {
        gameViewModel = new GameViewModel();
        rock.visibleProperty().bind(gameViewModel.rockButtonDisabledProperty());
        paper.visibleProperty().bind(gameViewModel.paperButtonDisabledProperty());
        scissor.visibleProperty().bind(gameViewModel.scissorButtonDisabledProperty());
        nextRound.visibleProperty().bind(gameViewModel.nextRoundButtonDisabledProperty());
        leave.visibleProperty().bind(gameViewModel.leaveButtonDisabledProperty());

        countdownLabel.textProperty().bind(gameViewModel.countdownLabelProperty());
    }

    public void onStartGame(ActionEvent actionEvent) {
        gameViewModel.startGame();
    }

    public void onLeave(ActionEvent actionEvent) {
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
}
