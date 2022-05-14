package de.riesenberg.rockpaperscissors.view;

import de.riesenberg.rockpaperscissors.RSPApplication;
import de.riesenberg.rockpaperscissors.viewmodel.WelcomeViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeView {

    private final WelcomeViewModel welcomeViewModel = new WelcomeViewModel();
    @FXML
    private Label welcomeLabel;

    @FXML
    private void initialize() {
        welcomeLabel.textProperty().bind(welcomeViewModel.welcomeLabelProperty());
    }

    public void onStartButton(ActionEvent actionEvent) {
        Stage labelStage = (Stage) welcomeLabel.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(RSPApplication.class.getResource("rsp-view.fxml"));

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        try {
            labelStage.setScene(new Scene(fxmlLoader.load(), bounds.getWidth() - 10, bounds.getHeight() - 30));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onMultiplayerButton(ActionEvent actionEvent) {
        Stage labelStage = (Stage) welcomeLabel.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(RSPApplication.class.getResource("lobby-view.fxml"));

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        try {
            labelStage.setScene(new Scene(fxmlLoader.load(), bounds.getWidth() - 10, bounds.getHeight() - 30));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
