package de.riesenberg.rpsbackend.service;

import de.riesenberg.rpsbackend.controller.GameRoundDto;
import de.riesenberg.rpsbackend.game.Game;
import de.riesenberg.rpsbackend.game.GameRound;
import de.riesenberg.rpsbackend.repository.GameRepository;
import de.riesenberg.rpsbackend.repository.GameRoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GameRoundRepository gameRoundRepository;

    @Autowired
    public GameService(GameRepository gameRepository, GameRoundRepository gameRoundRepository) {
        this.gameRepository = gameRepository;
        this.gameRoundRepository = gameRoundRepository;
    }

    public Game getGame(Long id) { return gameRepository.findById(id).orElseThrow(NoSuchElementException::new); }

    public List<Game> getOpenGames() {
        return gameRepository.findAll();
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void addRound(Long gameId, GameRound gameRound) {
        Game game = getGame(gameId);
        List<GameRound> gameRoundList = game.getGameRoundList();
        gameRoundList.add(gameRound);
        game.setGameRoundList(gameRoundList);
        gameRepository.save(game);
        gameRoundRepository.save(gameRound);
    }

    public void finishGame(Long gameId) {
        Game game = getGame(gameId);
        game.setFinished(true);
        gameRepository.save(game);
    }
}
