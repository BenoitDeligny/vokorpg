package vokorpgback.feature.fighting.domain;

import vokorpgback.feature.commons.domain.model.MonsterCombatDice;

public record FightingMonster(
        int maxFightingPower,
        int remainingFightingPower,
        MonsterCombatDice combatDice) {

    public FightingMonster(int maxFightingPower, int remainingFightingPower) {
        this(maxFightingPower, remainingFightingPower, computeCombatDice(maxFightingPower));
    }

    private static MonsterCombatDice computeCombatDice(int power) {
        for (MonsterCombatDice dice : MonsterCombatDice.values()) {
            if (power >= dice.getMinTotalPower() && power <= dice.getMaxTotalPower()) {
                return dice;
            }
        }
        return MonsterCombatDice.ZERO;
    }

    public boolean isDead() {
        return remainingFightingPower <= 0;
    }
}
