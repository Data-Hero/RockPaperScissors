package de.riesenberg.rockpaperscissors.view;

import de.riesenberg.rockpaperscissors.RSPApplication;
import de.riesenberg.rockpaperscissors.util.Util;
import de.riesenberg.rockpaperscissors.model.Game;
import de.riesenberg.rockpaperscissors.viewmodel.LobbyViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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
    private ObservableSet<Integer> rowsWithSelectedCells;

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

        lobbyTable.setPrefWidth(mainWindow.getWidth()*0.8);
        lobbyTable.setPrefHeight(mainWindow.getHeight()*0.8);

        rowsWithSelectedCells = FXCollections.observableSet();
        lobbyTable.getSelectionModel().getSelectedCells().addListener((ListChangeListener.Change<? extends TablePosition> c) -> {
            rowsWithSelectedCells.clear();
            Set<Integer> rows = lobbyTable.getSelectionModel().getSelectedCells().stream()
                    .map(TablePositionBase::getRow)
                    .collect(Collectors.toSet());
            rowsWithSelectedCells.addAll(rows);
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
        Stage labelStage = (Stage) mainWindow.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(RSPApplication.class.getResource("create-view.fxml"));
        try {
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            labelStage.setScene(new Scene(fxmlLoader.load(), bounds.getWidth() - 10, bounds.getHeight() - 30));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onRefresh(ActionEvent actionEvent) {
        lobbyViewModel.refresh();
    }

}
