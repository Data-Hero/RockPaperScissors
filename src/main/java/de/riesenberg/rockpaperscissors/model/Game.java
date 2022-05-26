package de.riesenberg.rockpaperscissors.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Game {

    private String name;
    private String password;
    private Integer round;
    private List<Boolean> winnerList;
    private HashMap<Integer, LinkedList<Item>> draw;

    public Game() {
        this.round = 0;
        winnerList = new LinkedList<>();
        draw = new HashMap<>();
        draw.put(0, new LinkedList<>());
        draw.put(1, new LinkedList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public HashMap<Integer, LinkedList<Item>> getDraw() {
        return draw;
    }

    public void setDraw(HashMap<Integer, LinkedList<Item>> draw) {
        this.draw = draw;
    }

    public boolean checkGameOver() {
        int playerWins = 0;
        int computerWins = 0;
        for (Boolean b : winnerList) {
            if (b) {
                playerWins++;
                if (playerWins >= 3) {
                    return true;
                }
            } else {
                computerWins++;
                if (computerWins >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public Integer addRound(Item playerOneChoice, Item playerTwoChoice) {
        if (playerOneChoice.compareTo(playerTwoChoice) == 0) {
            return 0;
        }
        this.round++;
        winnerList.add(playerOneChoice.compareTo(playerTwoChoice) > 0);
        draw.get(0).add(playerOneChoice);
        draw.get(1).add(playerTwoChoice);
        return playerOneChoice.compareTo(playerTwoChoice);
    }

}
