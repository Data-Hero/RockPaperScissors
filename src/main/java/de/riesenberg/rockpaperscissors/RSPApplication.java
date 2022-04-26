package de.riesenberg.rockpaperscissors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RSPApplication extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RSPApplication.class.getResource("welcome-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        primaryStage.setTitle("Schere, Stein, Papier!");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("C:\\Users\\Bijan\\IdeaProjects\\RockPaperScissors\\src\\main\\resources\\de\\riesenberg\\rockpaperscissors\\images\\icon.png"));
        this.primaryStage = primaryStage;
        this.primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void startGame(String fxml) {
        try {
            Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
            this.primaryStage.getScene().setRoot(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}