package vokorpgback.feature.fight.domain.model;

import vokorpgback.feature.commons.domain.model.opponent.Opponent;

public record Encounter(
        int numberOfOpponents,
        Opponent opponent
) {
}
