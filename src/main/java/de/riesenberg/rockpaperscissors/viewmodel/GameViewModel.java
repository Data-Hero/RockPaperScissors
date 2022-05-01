package de.riesenberg.rockpaperscissors.viewmodel;

import de.riesenberg.rockpaperscissors.model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class GameViewModel {


    private final BooleanProperty nextRoundButtonDisabled = new SimpleBooleanProperty(true);
    private final BooleanProperty leaveButtonDisabled = new SimpleBooleanProperty(true);
    private final BooleanProperty rockButtonDisabled = new SimpleBooleanProperty(false);
    private final BooleanProperty paperButtonDisabled = new SimpleBooleanProperty(false);
    private final BooleanProperty scissorButtonDisabled = new SimpleBooleanProperty(false);

    private final IntegerProperty winner = new SimpleIntegerProperty();

    private final StringProperty countdownLabel = new SimpleStringProperty();
    private final StringProperty winnerLabel = new SimpleStringProperty();

    private final ObjectProperty<Item> playerChoice = new SimpleObjectProperty<>();
    private final ObjectProperty<Item> computerChoice = new SimpleObjectProperty<>();

    private ObservableList<GameRound> winnerList;

    private Boolean isChoiceAvailable = Boolean.FALSE;

    private Game game;

    public GameViewModel(Game game) {
        this.game = game;
        this.setCountdownLabel("Scheere");
        winnerList = FXCollections.observableArrayList();
    }

    public GameViewModel() {
        this.game = new Game();
        this.setCountdownLabel("Scheere");
        winnerList = FXCollections.observableArrayList();
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


    public void startRound() {
        rockButtonDisabled.set(true);
        paperButtonDisabled.set(true);
        scissorButtonDisabled.set(true);
        nextRoundButtonDisabled.set(false);
        leaveButtonDisabled.set(false);
        this.setCountdownLabel("Scheere");
        this.runCountdown();
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
        rockButtonDisabled.set(false);
        paperButtonDisabled.set(false);
        scissorButtonDisabled.set(false);
        nextRoundButtonDisabled.set(true);
        leaveButtonDisabled.set(true);
        if (game.checkGameOver()) {
            setNextRoundButtonDisabled(false);
        }
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

    public void setPlayerChoice(Item playerChoice) {
        this.playerChoice.set(playerChoice);
    }

    public ObjectProperty<Item> playerChoiceProperty() {
        return playerChoice;
    }

    public Item getComputerChoice() {
        return computerChoice.get();
    }

    public void setComputerChoice(Item computerChoice) {
        this.computerChoice.set(computerChoice);
    }

    public ObjectProperty<Item> computerChoiceProperty() {
        return computerChoice;
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

    public void setNextRoundButtonDisabled(boolean nextRoundButtonDisabled) {
        this.nextRoundButtonDisabled.set(nextRoundButtonDisabled);
    }

    public BooleanProperty nextRoundButtonDisabledProperty() {
        return nextRoundButtonDisabled;
    }

    public boolean isLeaveButtonDisabled() {
        return leaveButtonDisabled.get();
    }

    public void setLeaveButtonDisabled(boolean leaveButtonDisabled) {
        this.leaveButtonDisabled.set(leaveButtonDisabled);
    }

    public BooleanProperty leaveButtonDisabledProperty() {
        return leaveButtonDisabled;
    }

    public boolean isRockButtonDisabled() {
        return rockButtonDisabled.get();
    }

    public void setRockButtonDisabled(boolean rockButtonDisabled) {
        this.rockButtonDisabled.set(rockButtonDisabled);
    }

    public BooleanProperty rockButtonDisabledProperty() {
        return rockButtonDisabled;
    }

    public boolean isPaperButtonDisabled() {
        return paperButtonDisabled.get();
    }

    public void setPaperButtonDisabled(boolean paperButtonDisabled) {
        this.paperButtonDisabled.set(paperButtonDisabled);
    }

    public BooleanProperty paperButtonDisabledProperty() {
        return paperButtonDisabled;
    }

    public boolean isScissorButtonDisabled() {
        return scissorButtonDisabled.get();
    }

    public void setScissorButtonDisabled(boolean scissorButtonDisabled) {
        this.scissorButtonDisabled.set(scissorButtonDisabled);
    }

    public BooleanProperty scissorButtonDisabledProperty() {
        return scissorButtonDisabled;
    }

    public String getCountdownLabel() {
        return countdownLabel.get();
    }

    public void setCountdownLabel(String countdownLabel) {
        this.countdownLabel.set(countdownLabel);
    }

    public StringProperty countdownLabelProperty() {
        return countdownLabel;
    }

    public String getWinnerLabel() {
        return winnerLabel.get();
    }

    public void setWinnerLabel(String winnerLabel) {
        this.winnerLabel.set(winnerLabel);
    }

    public StringProperty winnerLabelProperty() {
        return winnerLabel;
    }

    public int getWinner() {
        return winner.get();
    }

    public void setWinner(int winner) {
        this.winner.set(winner);
    }

    public IntegerProperty winnerProperty() {
        return winner;
    }

    public ObservableList<GameRound> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(ObservableList<GameRound> winnerList) {
        this.winnerList = winnerList;
    }

}

