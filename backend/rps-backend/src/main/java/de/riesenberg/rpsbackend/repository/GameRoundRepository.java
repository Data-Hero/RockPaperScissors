package de.riesenberg.rpsbackend.repository;

import de.riesenberg.rpsbackend.game.GameRound;
import org.springframework.data.repository.ListCrudRepository;

public interface GameRoundRepository extends ListCrudRepository<GameRound, Long> {
}
