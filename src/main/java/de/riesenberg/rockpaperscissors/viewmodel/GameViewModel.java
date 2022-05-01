package de.riesenberg.rockpaperscissors.viewmodel;

import de.riesenberg.rockpaperscissors.model.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.util.Duration;

public class GameViewModel {


    private BooleanProperty nextRoundButtonDisabled = new SimpleBooleanProperty(true);
    private BooleanProperty leaveButtonDisabled = new SimpleBooleanProperty(true);
    private BooleanProperty rockButtonDisabled = new SimpleBooleanProperty(false);
    private BooleanProperty paperButtonDisabled = new SimpleBooleanProperty(false);
    private BooleanProperty scissorButtonDisabled = new SimpleBooleanProperty(false);

    private StringProperty countdownLabel = new SimpleStringProperty();

    private Game game;

    public GameViewModel(Game game) {
        this.game = game;
        this.setCountdownLabel("Scheere");
    }

    public GameViewModel() {
        this.game = new Game();
        System.out.println(rockButtonDisabled.get());
        this.setCountdownLabel("Scheere");
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

    @FXML
    public void startGame() {
        rockButtonDisabled.set(true);
        paperButtonDisabled.set(true);
        scissorButtonDisabled.set(true);
        nextRoundButtonDisabled.set(false);
        leaveButtonDisabled.set(false);
        this.runCountdown();
    }

    @FXML
    public void noGame() {
        rockButtonDisabled.set(false);
        paperButtonDisabled.set(false);
        scissorButtonDisabled.set(false);
        nextRoundButtonDisabled.set(true);
        leaveButtonDisabled.set(true);
    }

    private void runCountdown() {
        Timeline timeline =
                new Timeline(new KeyFrame(Duration.millis(1000),
                        e -> {
                    String decreased = decrease(this.getCountdownLabel());
                    this.setCountdownLabel(decreased);
                }));
        timeline.setCycleCount(5);
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

}