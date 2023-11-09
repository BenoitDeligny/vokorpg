package vokorpgback.feature.fight.domain.model;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;

public record CombatResult(
        CombatState combatState,
        LegendaryCharacter legendaryCharacter,
        Encounter encounter
) {
}
