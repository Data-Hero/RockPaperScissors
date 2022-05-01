package de.riesenberg.rockpaperscissors.viewmodel;

import de.riesenberg.rockpaperscissors.model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.util.Duration;

import java.util.LinkedList;

public class GameViewModel {


    private BooleanProperty nextRoundButtonDisabled = new SimpleBooleanProperty(true);
    private BooleanProperty leaveButtonDisabled = new SimpleBooleanProperty(true);
    private BooleanProperty rockButtonDisabled = new SimpleBooleanProperty(false);
    private BooleanProperty paperButtonDisabled = new SimpleBooleanProperty(false);
    private BooleanProperty scissorButtonDisabled = new SimpleBooleanProperty(false);

    private IntegerProperty winner = new SimpleIntegerProperty();

    private StringProperty countdownLabel = new SimpleStringProperty();
    private StringProperty winnerLabel = new SimpleStringProperty();

    private ObjectProperty<Item> playerChoice = new SimpleObjectProperty<>();
    private ObjectProperty<Item> computerChoice = new SimpleObjectProperty<>();

    private ObservableList<GameRound> winnerList;

    private Boolean isChoiceAvailable = Boolean.FALSE;

    private Game game;

    public GameViewModel(Game game) {
        this.game = game;
        this.setCountdownLabel("Scheere");
        winnerList = FXCollections.observableList(new LinkedList<>());
    }

    public GameViewModel() {
        this.game = new Game();
        this.setCountdownLabel("Scheere");
        winnerList = FXCollections.observableList(new LinkedList<>());
    }

    private void runCountdown() {
        this.isChoiceAvailable = Boolean.TRUE;
        Timeline timeline =
                new Timeline(new KeyFrame(Duration.millis(1000),
                        e -> {
                            String decreased = decrease(this.getCountdownLabel());
                            this.setCountdownLabel(decreased);
                        }));
        timeline.setCycleCount(5);
        timeline.onFinishedProperty().set((ActionEvent ae) -> {
            isChoiceAvailable = Boolean.FALSE;
            endRound();
        });
        timeline.play();
    }

    private String decrease(String value) {
        return switch (value) {
            case "5" -> "4";
            case "4" -> "Scheere";
            case "Scheere" -> "Stein";
            case "Stein" -> "Papier";
            default -> "Resultat";
        };
    }


    public boolean startRound() {
        if (game.checkGameOver()) {
            return false;
        }
        rockButtonDisabled.set(true);
        paperButtonDisabled.set(true);
        scissorButtonDisabled.set(true);
        nextRoundButtonDisabled.set(false);
        leaveButtonDisabled.set(false);
        this.setCountdownLabel("Scheere");
        this.runCountdown();
        return true;
    }


    public void endRound() {
        computerChoice.set(Computer.makeChoice());

        Integer result = game.addRound(
                this.playerChoice.getValue() == null ?
                        new Item(ItemEnum.NONE) :
                        this.playerChoice.getValue(),
                getComputerChoice()
        );
        setWinner(result);
        winnerList.add(new GameRound(getPlayerChoice(), getComputerChoice()));
        System.out.println(winnerList);
        rockButtonDisabled.set(false);
        paperButtonDisabled.set(false);
        scissorButtonDisabled.set(false);
        nextRoundButtonDisabled.set(true);
        leaveButtonDisabled.set(true);
    }

    public void reset() {
        this.game = new Game();
    }


    public Boolean chooseRock() {
        if (this.isChoiceAvailable) {
            setPlayerChoice(new Item(ItemEnum.ROCK));
        }
        return this.isChoiceAvailable;
    }

    public Boolean choosePaper() {
        if (this.isChoiceAvailable) {
            setPlayerChoice(new Item(ItemEnum.PAPER));
        }
        return this.isChoiceAvailable;
    }

    public Boolean chooseScissor() {
        if (this.isChoiceAvailable) {
            setPlayerChoice(new Item(ItemEnum.SCISSOR));
        }
        return this.isChoiceAvailable;
    }

    public Item getPlayerChoice() {
        return playerChoice.get();
    }

    public ObjectProperty<Item> playerChoiceProperty() {
        return playerChoice;
    }

    public void setPlayerChoice(Item playerChoice) {
        this.playerChoice.set(playerChoice);
    }

    public Item getComputerChoice() {
        return computerChoice.get();
    }

    public ObjectProperty<Item> computerChoiceProperty() {
        return computerChoice;
    }

    public void setComputerChoice(Item computerChoice) {
        this.computerChoice.set(computerChoice);
    }

    public Boolean getChoiceAvailable() {
        return isChoiceAvailable;
    }

    public void setChoiceAvailable(Boolean choiceAvailable) {
        isChoiceAvailable = choiceAvailable;
    }

    public boolean isNextRoundButtonDisabled() {
        return nextRoundButtonDisabled.get();
    }

    public BooleanProperty nextRoundButtonDisabledProperty() {
        return nextRoundButtonDisabled;
    }

    public void setNextRoundButtonDisabled(boolean nextRoundButtonDisabled) {
        this.nextRoundButtonDisabled.set(nextRoundButtonDisabled);
    }

    public boolean isLeaveButtonDisabled() {
        return leaveButtonDisabled.get();
    }

    public BooleanProperty leaveButtonDisabledProperty() {
        return leaveButtonDisabled;
    }

    public void setLeaveButtonDisabled(boolean leaveButtonDisabled) {
        this.leaveButtonDisabled.set(leaveButtonDisabled);
    }

    public boolean isRockButtonDisabled() {
        return rockButtonDisabled.get();
    }

    public BooleanProperty rockButtonDisabledProperty() {
        return rockButtonDisabled;
    }

    public void setRockButtonDisabled(boolean rockButtonDisabled) {
        this.rockButtonDisabled.set(rockButtonDisabled);
    }

    public boolean isPaperButtonDisabled() {
        return paperButtonDisabled.get();
    }

    public BooleanProperty paperButtonDisabledProperty() {
        return paperButtonDisabled;
    }

    public void setPaperButtonDisabled(boolean paperButtonDisabled) {
        this.paperButtonDisabled.set(paperButtonDisabled);
    }

    public boolean isScissorButtonDisabled() {
        return scissorButtonDisabled.get();
    }

    public BooleanProperty scissorButtonDisabledProperty() {
        return scissorButtonDisabled;
    }

    public void setScissorButtonDisabled(boolean scissorButtonDisabled) {
        this.scissorButtonDisabled.set(scissorButtonDisabled);
    }

    public String getCountdownLabel() {
        return countdownLabel.get();
    }

    public StringProperty countdownLabelProperty() {
        return countdownLabel;
    }

    public void setCountdownLabel(String countdownLabel) {
        this.countdownLabel.set(countdownLabel);
    }


    public String getWinnerLabel() {
        return winnerLabel.get();
    }

    public StringProperty winnerLabelProperty() {
        return winnerLabel;
    }

    public void setWinnerLabel(String winnerLabel) {
        this.winnerLabel.set(winnerLabel);
    }

    public int getWinner() {
        return winner.get();
    }

    public IntegerProperty winnerProperty() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner.set(winner);
    }

    public ObservableList<GameRound> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(ObservableList<GameRound> winnerList) {
        this.winnerList = winnerList;
    }


}