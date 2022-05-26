package de.riesenberg.rockpaperscissors.viewmodel;

import de.riesenberg.rockpaperscissors.model.Game;

import java.util.HashMap;
import java.util.LinkedList;

public class CreateViewModel {



    public void create(String name, String password) {
        Game game = new Game();
        game.setName(name);
        game.setPassword(password);
        game.setRound(0);
        game.setDraw(new HashMap<>());
        game.setWinnerList(new LinkedList<>());
    }


}
