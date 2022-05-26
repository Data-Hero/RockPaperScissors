package de.riesenberg.rockpaperscissors.model;

import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import de.riesenberg.rockpaperscissors.util.Requests;

import java.util.Arrays;
import java.util.List;

public class Lobby {

    List<Game> gameList;

    public Lobby() throws UnirestException {
        gameList = Arrays.asList(new Gson().fromJson(Requests.getGames().toString(), Game[].class));
    }

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
