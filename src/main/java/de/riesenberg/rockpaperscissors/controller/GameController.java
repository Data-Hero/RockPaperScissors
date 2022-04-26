package de.riesenberg.rockpaperscissors.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameController {

    @FXML
    public Label countdown;


    @FXML
    private void initialize() {
        countdown.setText("Start the Round");
    }


    @FXML
    protected void onHelloButtonClick() {

    }
}