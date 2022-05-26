package de.riesenberg.rpsbackend.game;

import de.riesenberg.rpsbackend.controller.GameRoundDto;
import jakarta.persistence.*;

@Entity
@Table(name="GAMEROUND")
public class GameRound {
    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;
    @Column private Integer numberOfRound;
    @Enumerated(EnumType.STRING) private Item playerOneChoice;
    @Enumerated(EnumType.STRING) private Item playerTwoChoice;
    @ManyToOne private Game game;

    public GameRound() {}

    public GameRound(GameRoundDto gameRoundDto, Game game) {
        this.numberOfRound = gameRoundDto.getNumberOfRound();
        this.playerOneChoice = gameRoundDto.getPlayerOneChoice();
        this.playerTwoChoice = gameRoundDto.getPlayerTwoChoice();
        this.game = game;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Item getPlayerOneChoice() {
        return playerOneChoice;
    }

    public void setPlayerOneChoice(Item playerOneChoice) {
        this.playerOneChoice = playerOneChoice;
    }

    public Item getPlayerTwoChoice() {
        return playerTwoChoice;
    }

    public void setPlayerTwoChoice(Item playerTwoChoice) {
        this.playerTwoChoice = playerTwoChoice;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getNumberOfRound() {
        return numberOfRound;
    }

    public void setNumberOfRound(Integer numberOfRound) {
        this.numberOfRound = numberOfRound;
    }
}
