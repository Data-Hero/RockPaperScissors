package de.riesenberg.rockpaperscissors.viewmodel;

import de.riesenberg.rockpaperscissors.model.Game;
import de.riesenberg.rockpaperscissors.model.Lobby;
import javafx.collections.ObservableList;

public class LobbyViewModel {
    private ObservableList<Game> gameList;
    private Lobby lobby;

    public void join() {

    }

    public void create() {

    }


    public ObservableList<Game> getGameList() {
        return gameList;
    }

    public void setGameList(ObservableList<Game> gameList) {
        this.gameList = gameList;
    }

    public Lobby getLobby() {
        return lobby;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }
}
