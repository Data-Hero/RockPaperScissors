package de.riesenberg.rpsbackend.repository;

import de.riesenberg.rpsbackend.domain.GameRound;
import org.springframework.data.repository.ListCrudRepository;

public interface GameRoundRepository extends ListCrudRepository<GameRound, Long> {
}
