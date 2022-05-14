package de.riesenberg.rockpaperscissors.view;

import de.riesenberg.rockpaperscissors.RSPApplication;
import de.riesenberg.rockpaperscissors.Util;
import de.riesenberg.rockpaperscissors.model.Game;
import de.riesenberg.rockpaperscissors.model.GameRound;
import de.riesenberg.rockpaperscissors.model.Item;
import de.riesenberg.rockpaperscissors.model.ItemEnum;
import de.riesenberg.rockpaperscissors.viewmodel.LobbyViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class LobbyView {

    @FXML
    public TableView<Game> lobbyTable;
    @FXML
    public TableColumn<Game, String> nameColumn;
    @FXML
    public TableColumn<Game, String> passwordRequiredColumn;
    @FXML
    private AnchorPane mainWindow;
    @FXML
    private Button leave;
    @FXML
    private Button join;
    @FXML
    private Button create;

    private LobbyViewModel lobbyViewModel;

    @FXML
    private void initialize() {
        lobbyViewModel = new LobbyViewModel();

        lobbyViewModel.setGameList(FXCollections.observableArrayList());
        lobbyTable.setItems(lobbyViewModel.getGameList());
        nameColumn.setCellValueFactory(cellData -> {
            Game game = cellData.getValue();
            String name = game.getName();
            if (name == null || name.isEmpty()) {
                name = Util.generateString(new Random(),
                        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",
                        new Random().nextInt(10)+10);
            }
            return new SimpleStringProperty(name);
        });

        passwordRequiredColumn.setCellValueFactory(cellData -> {
            Game game = cellData.getValue();
            String name = game.getPassword();
            return new SimpleStringProperty(name == null || name.isEmpty() ? "NO" : "YES");
        });
    }

    public void onLeave(ActionEvent actionEvent) {
        Stage labelStage = (Stage) mainWindow.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(RSPApplication.class.getResource("welcome-view.fxml"));
        try {
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            labelStage.setScene(new Scene(fxmlLoader.load(), bounds.getWidth() - 10, bounds.getHeight() - 30));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void onJoin(ActionEvent actionEvent) {
        lobbyViewModel.join();
    }
    public void onCreate(ActionEvent actionEvent) {
        lobbyViewModel.create();
    }

}