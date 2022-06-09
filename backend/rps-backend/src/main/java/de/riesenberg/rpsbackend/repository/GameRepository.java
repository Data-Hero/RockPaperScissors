package de.riesenberg.rpsbackend.repository;

import de.riesenberg.rpsbackend.domain.Game;
import org.springframework.data.repository.ListCrudRepository;

public interface GameRepository extends ListCrudRepository<Game, Long> {
}
