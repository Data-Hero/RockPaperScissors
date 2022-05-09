package de.riesenberg.rpsbackend.repository;

import de.riesenberg.rpsbackend.game.Game;
import org.springframework.data.repository.ListCrudRepository;

public interface GameRepository extends ListCrudRepository<Game, Long> {
}
