package de.riesenberg.rpsbackend.service;

import de.riesenberg.rpsbackend.game.Game;
import de.riesenberg.rpsbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public List<Game> getOpenGames() {
        return gameRepository.findAll();
    }

}
