package de.riesenberg.rockpaperscissors.model;

import java.util.List;

public class Lobby {

    List<Game> gameList;

    public Lobby() {}

    public Lobby(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
