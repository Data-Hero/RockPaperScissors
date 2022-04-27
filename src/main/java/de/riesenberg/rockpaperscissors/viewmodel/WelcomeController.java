package de.riesenberg.rockpaperscissors.viewmodel;

import de.riesenberg.rockpaperscissors.RSPApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private AnchorPane mainWindow;

    @FXML
    private Label welcomeText;

    @FXML
    private void initialize() {
        welcomeText.setText("Wilkommen bei Schere, Stein, Papier");
    }

    @FXML
    protected void onStartButton(ActionEvent event) {
        Stage labelStage = (Stage) welcomeText.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(RSPApplication.class.getResource("rsp-view.fxml"));

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        try {
            labelStage.setScene(new Scene(fxmlLoader.load(), bounds.getWidth()-10,bounds.getHeight()-30 ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
