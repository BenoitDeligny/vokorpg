package vokorpgback.feature.fighting.domain;

import vokorpgback.feature.commons.domain.model.CharacterCombatDice;

public record FightingCharacter(
        int maxFightingPower,
        int remainingFightingPower,
        int agility,
        CharacterCombatDice combatDice) {

    public FightingCharacter(int maxFightingPower, int remainingFightingPower, int agilty) {
        this.maxFightingPower = maxFightingPower;
        this.remainingFightingPower = remainingFightingPower;
        this.agility = agilty;
        this.combatDice = computeCombatDice();
    }

    private CharacterCombatDice computeCombatDice() {
        for (CharacterCombatDice dice : CharacterCombatDice.values()) {
            if (remainingFightingPower >= dice.getMinTotalPower() && remainingFightingPower <= dice.getMaxTotalPower()) {
                return dice;
            }
        }
        return CharacterCombatDice.ZERO;
    }

    public boolean isDead() {
        return remainingFightingPower <= 0;
    }
}
