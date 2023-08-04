package vokorpgback.feature.fight.domain.model;

import java.util.UUID;

public record Opponent(
        UUID uuid,
        String name,
        FightingMight fightingMight
        // TODO add specialization (damages, rules, ...)
)
{
    record FightingMight(int maxNaturalMight, int remainingMight, OpponentCombatChart opponentCombatChart) {
    }
}
