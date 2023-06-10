package vokorpgback.feature.commons.domain.model.character;

public record FightingMight(
        int maxNaturalMight,
        int maxTotalMight,
        int remainingMight,
        CharacterCombatChart characterCombatChart
) {
}
