package vokorpgback.feature.commons.domain.model.opponent;

import vokorpgback.feature.commons.domain.model.might.FightingMight;

import java.util.UUID;

public record Opponent(
        UUID uuid,
        String name,
        OpponentFightingMight fightingMight
        // TODO add specialization (damages, rules, ...)
)
{
}
