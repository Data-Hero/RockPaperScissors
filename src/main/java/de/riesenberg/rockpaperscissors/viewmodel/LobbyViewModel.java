package de.riesenberg.rockpaperscissors.viewmodel;

import com.mashape.unirest.http.exceptions.UnirestException;
import de.riesenberg.rockpaperscissors.model.Game;
import de.riesenberg.rockpaperscissors.model.Lobby;
import de.riesenberg.rockpaperscissors.util.Requests;
import javafx.collections.ObservableList;

public class LobbyViewModel {
    private ObservableList<Game> gameList;
    private Lobby lobby;

    public LobbyViewModel() {
        try {
            this.lobby = new Lobby();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void join() {

    }

    public ObservableList<Game> getGameList() {
        return gameList;
    }

    public void updateGameList() {
        try {
            var x = Requests.getGames();
            System.out.println(x);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
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

    public void refresh() {
    }
}
