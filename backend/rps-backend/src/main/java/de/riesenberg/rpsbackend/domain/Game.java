package de.riesenberg.rpsbackend.domain;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="GAME")
public class Game implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;
    @Column private String name;
    @Column private Boolean open;
    @Column private Boolean finished;
    @OneToMany List<GameRound> gameRoundList;


    public Game() {}

    public Game(String name, Boolean open, Boolean finished, List<GameRound> gameRoundList) {
        new Game();
        this.name = name;
        this.open = open;
        this.finished = finished;
        this.gameRoundList = gameRoundList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public List<GameRound> getGameRoundList() {
        return gameRoundList;
    }

    public void setGameRoundList(List<GameRound> gameRoundList) {
        this.gameRoundList = gameRoundList;
    }
}
