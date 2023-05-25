package vokorpgback.feature.fighting.domain;

import vokorpgback.feature.commons.domain.model.MonsterCombatDice;

public record FightingMonster(
        int maxFightingPower,
        int remainingFightingPower,
        MonsterCombatDice combatDice) {

    public FightingMonster(int maxFightingPower, int remainingFightingPower) {
        this.maxFightingPower = maxFightingPower;
        this.remainingFightingPower = remainingFightingPower;
        this.combatDice = computeCombatDice();
    }

    private MonsterCombatDice computeCombatDice() {
        for (MonsterCombatDice dice : MonsterCombatDice.values()) {
            if (remainingFightingPower >= dice.getMinTotalPower() && remainingFightingPower <= dice.getMaxTotalPower()) {
                return dice;
            }
        }
        return MonsterCombatDice.ZERO;
    }

    public boolean isDead() {
        return remainingFightingPower <= 0;
    }
}
