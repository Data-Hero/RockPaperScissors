package com.example.rpsbackend.repository;

import com.example.rpsbackend.game.Game;
import org.springframework.data.repository.ListCrudRepository;

public interface GameRepository extends ListCrudRepository<Game, Long> {
}
