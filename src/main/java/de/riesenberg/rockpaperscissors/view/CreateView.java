package de.riesenberg.rockpaperscissors.view;

import de.riesenberg.rockpaperscissors.RSPApplication;
import de.riesenberg.rockpaperscissors.viewmodel.CreateViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateView {

    @FXML TextField gameName;
    @FXML TextField gamePassword;
    @FXML Button leave;
    @FXML Button create;
    @FXML AnchorPane mainWindow;

    private CreateViewModel createViewModel;

    @FXML
    private void initialize() {
        createViewModel = new CreateViewModel();
        gameName.getStyleClass().remove("error");
        gameName.setPromptText("Name");
        gamePassword.setPromptText("Password (optional)");
    }


    public void onLeave(ActionEvent actionEvent) {
        Stage labelStage = (Stage) mainWindow.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(RSPApplication.class.getResource("lobby-view.fxml"));
        try {
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            labelStage.setScene(new Scene(fxmlLoader.load(), bounds.getWidth() - 10, bounds.getHeight() - 30));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onCreate(ActionEvent actionEvent) {
        System.out.println(gameName.getText().isBlank());
        if (gameName.getText().isBlank()) {
            gameName.setStyle("-fx-border-color: #d35244; " +
                    "-fx-border-width: 1 1 1 1; " +
                    "-fx-faint-focus-color: #d3524422");
        } else {
            createViewModel.create(gameName.getText(), gamePassword.getText());
        }

    }
}
