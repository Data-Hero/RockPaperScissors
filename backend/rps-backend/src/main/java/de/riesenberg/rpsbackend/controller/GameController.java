package de.riesenberg.rpsbackend.controller;

import de.riesenberg.rpsbackend.domain.Game;
import de.riesenberg.rpsbackend.domain.GameRound;
import de.riesenberg.rpsbackend.service.GameService;
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

    @GetMapping("/game/{gameId}")
    public GameDto getGame(@PathVariable Long gameId) {
        return gameToGameDto(gameService.getGame(gameId));
    }

    @GetMapping("/games")
    public List<GameDto> getOpenGames() {
        return gameService.getOpenGames()
                .stream()
                .map(this::gameToGameDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/game/add")
    public void addGame(@RequestBody GameDto gameDto) {
        this.gameService.addGame(new Game(gameDto.name(), gameDto.open(), gameDto.finished(), gameDto.gameRoundList()));
    }

    @PostMapping("/game/join")
    public void joinGame(@RequestBody GameDto gameDto) {
        this.gameService.joinGame(new Game(gameDto.name(), gameDto.open(), gameDto.finished(), gameDto.gameRoundList()));
    }


    @PostMapping("/game/{}/round/add")
    public void addRound(@PathVariable Long gameId, @RequestBody GameRoundDto gameRoundDto) {
        Game game = gameService.getGame(gameId);
        this.gameService.addRound(gameId, new GameRound(gameRoundDto, game));
    }


    @PostMapping("/game/{}/finish")
    public void finishGame(@PathVariable Long gameId) {
        this.gameService.finishGame(gameId);
    }


    private GameDto gameToGameDto(Game game) {
        return new GameDto(game.getId(), game.getName(), game.getOpen(), game.getFinished(), game.getGameRoundList());
    }

}
