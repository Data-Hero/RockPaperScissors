package com.example.rpsbackend.controller;

import com.example.rpsbackend.game.Game;
import com.example.rpsbackend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("game")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)

public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game")
    public GameDto getGame() {
        return null;
    }

    @GetMapping("/games")
    public List<GameDto> getOpenGames() {
        return gameService.getOpenGames()
                .stream()
                .map(game -> new GameDto(game.name(), game.open(), game.finished()))
                .collect(Collectors.toList());
    }

    @PostMapping("/game/add")
    public void addGame(@RequestBody GameDto gameDto) {
        this.gameService.addGame(new Game(gameDto.name(), gameDto.open(), gameDto.finished()));
    }


    @PostMapping("/round/add")
    public void addRound(@RequestBody RoundDto roundDto) {

    }


}
