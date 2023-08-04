package vokorpgback.feature.fight.domain.model;

public record Encounter(
        int numberOfOpponents,
        Opponent opponent
) {
}
