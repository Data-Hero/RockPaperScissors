package de.riesenberg.rpsbackend.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.riesenberg.rpsbackend.domain.GameRound;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public record GameDto(Long id, String name, Boolean open, Boolean finished, List<GameRound> gameRoundList) {
}
