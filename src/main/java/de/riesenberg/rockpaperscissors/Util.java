package de.riesenberg.rockpaperscissors;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Random;

public class Util {


    public static JsonNode readUrl(String urlString) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(urlString)
                .header("accept", "application/json").queryString("apiKey", "123")
                .asJson();
        return response.getBody();
    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
