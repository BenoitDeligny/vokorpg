package vokorpgback.feature.commons.domain.model;

import vokorpgback.feature.commons.domain.port.Dice;

import java.util.List;

public record Power(
        int maxNaturalPower,
        int maxTotalPower,
        int remainingPower,
        CharacterCombatChart characterCombatChart
) {
}
