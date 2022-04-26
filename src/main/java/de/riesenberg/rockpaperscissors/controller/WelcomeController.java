package de.riesenberg.rockpaperscissors.controller;

import de.riesenberg.rockpaperscissors.RSPApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    private Stage stage;

    @FXML
    private Label welcomeText;

    @FXML
    private void initialize() {
        welcomeText.setText("Wilkommen bei Schere, Stein, Papier");
    }

    @FXML
    protected void onStartButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(RSPApplication.class.getResource("rsp-view.fxml"));
        try {
            stage.setScene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
