package de.riesenberg.rockpaperscissors.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GameModel {
    private Integer round;
    private List<Boolean> winnerList;
    private HashMap<Integer, LinkedList> draw;

    public GameModel() {
        this.round = 0;
        winnerList = new LinkedList<>();
        HashMap<Integer, LinkedList> draw;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public List<Boolean> getWinnerList() {
        return winnerList;
    }

    public void setWinnerList(List<Boolean> winnerList) {
        this.winnerList = winnerList;
    }

    public boolean checkGameOver() {
        int playerWins = 0;
        int computerWins = 0;
        for (Boolean b: winnerList) {
            if(b) {
                playerWins++;
                if(playerWins >= 3) {
                    return true;
                }
            } else {
                computerWins++;
                if(computerWins >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addRound(Boolean winner) {
        this.round++;
        winnerList.add(winner);
    }



}
