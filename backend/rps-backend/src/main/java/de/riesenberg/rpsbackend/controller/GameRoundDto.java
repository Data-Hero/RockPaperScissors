package de.riesenberg.rpsbackend.controller;

import de.riesenberg.rpsbackend.game.GameRound;
import de.riesenberg.rpsbackend.game.Item;

public class GameRoundDto {
    Long gameId;
    Integer numberOfRound;
    Item playerOneChoice;
    Item playerTwoChoice;

    public GameRoundDto() {
    }

    public GameRoundDto(GameRound gameRound) {
        this.gameId = gameRound.getGame().getId();
        this.numberOfRound = gameRound.getNumberOfRound();
        this.playerOneChoice = gameRound.getPlayerOneChoice();
        this.playerTwoChoice = gameRound.getPlayerTwoChoice();
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getNumberOfRound() {
        return numberOfRound;
    }

    public void setNumberOfRound(Integer numberOfRound) {
        this.numberOfRound = numberOfRound;
    }

    public Item getPlayerOneChoice() {
        return playerOneChoice;
    }

    public void setPlayerOneChoice(Item playerOneChoice) {
        this.playerOneChoice = playerOneChoice;
    }

    public Item getPlayerTwoChoice() {
        return playerTwoChoice;
    }

    public void setPlayerTwoChoice(Item playerTwoChoice) {
        this.playerTwoChoice = playerTwoChoice;
    }
}
