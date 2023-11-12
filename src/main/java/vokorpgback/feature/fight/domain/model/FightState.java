package vokorpgback.feature.fight.domain.model;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;

public record FightState(
        FightResult fightResult,
        LegendaryCharacter legendaryCharacter,
        Encounter encounter
) {
}
