package com.example.rpsbackend.service;

import com.example.rpsbackend.controller.GameDto;
import com.example.rpsbackend.game.Game;
import com.example.rpsbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
