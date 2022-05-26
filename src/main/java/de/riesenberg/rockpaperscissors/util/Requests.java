package de.riesenberg.rockpaperscissors.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import de.riesenberg.rockpaperscissors.model.Game;


public class Requests {

    public static final String BASE_URL = "http://localhost:9000/game/";

    public static JsonNode getGames() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(BASE_URL+"games")
                .header("accept", "application/json") // .queryString("apiKey", "123")
                .asJson();
        return response.getBody();
    }

    public static JsonNode getGame(Long gameId) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(BASE_URL+"game/"+gameId)
                .header("accept", "application/json")
                .asJson();
        return response.getBody();
    }

    public static void postGame(Game game) {
        Unirest.post(BASE_URL+"game").header("accept", "application/json").body(game);
    }



}
