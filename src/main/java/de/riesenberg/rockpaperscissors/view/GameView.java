package de.riesenberg.rockpaperscissors.view;

import de.riesenberg.rockpaperscissors.RSPApplication;
import de.riesenberg.rockpaperscissors.model.GameRound;
import de.riesenberg.rockpaperscissors.model.Item;
import de.riesenberg.rockpaperscissors.model.ItemEnum;
import de.riesenberg.rockpaperscissors.viewmodel.GameViewModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GameView {
    @FXML
    public TableColumn<GameRound, String> playerOneTableColumn;
    @FXML
    public TableColumn<GameRound, String> playerTwoTableColumn;
    @FXML
    public Label winnerLabel;
    @FXML
    public TableView<GameRound> resultTable;
    @FXML
    private Label countdownLabel;
    @FXML
    private Button nextRound;
    @FXML
    private Button leave;
    @FXML
    private Button rock;
    @FXML
    private Button paper;
    @FXML
    private Button scissor;

    @FXML
    private ImageView playerChoice;

    @FXML
    private ImageView computerChoice;

    @FXML
    private SplitPane splitPane;

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
        winnerLabel.textProperty().bind(gameViewModel.winnerLabelProperty());

        List<GameRound> ll = List.of(new GameRound(new Item(ItemEnum.ROCK), new Item(ItemEnum.SCISSOR)));
        gameViewModel.setWinnerList(FXCollections.observableList(ll));
        resultTable.setItems(gameViewModel.getWinnerList());
        playerOneTableColumn.setCellValueFactory(cellData -> {
            GameRound gameRound = cellData.getValue();
            return new SimpleStringProperty(gameRound.playerOneChoice().toString());
        });

        playerTwoTableColumn.setCellValueFactory(cellData -> {
            GameRound gameRound = cellData.getValue();
            return new SimpleStringProperty(gameRound.playerTwoChoice().toString());
        });
    }

    public void onStartGame(ActionEvent actionEvent) {
        gameViewModel.startRound();
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

    public void onReset(ActionEvent actionEvent) {
        gameViewModel.reset();
    }

    public void onRock(ActionEvent actionEvent) {
        gameViewModel.chooseRock();
    }

    public void onPaper(ActionEvent actionEvent) {
        gameViewModel.choosePaper();
    }

    public void onScissor(ActionEvent actionEvent) {
        gameViewModel.chooseScissor();
    }


}
