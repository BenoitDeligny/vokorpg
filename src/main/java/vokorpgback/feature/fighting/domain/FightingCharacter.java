package vokorpgback.feature.fighting.domain;

import vokorpgback.feature.commons.domain.model.CharacterCombatDice;

public record FightingCharacter(
        int maxFightingPower,
        int remainingFightingPower,
        int agility,
        CharacterCombatDice combatDice) {

    public FightingCharacter(int maxFightingPower, int remainingFightingPower, int agilty) {
        this(maxFightingPower, remainingFightingPower, agilty, computeCombatDice(maxFightingPower));
    }

    private static CharacterCombatDice computeCombatDice(int power) {
        for (CharacterCombatDice dice : CharacterCombatDice.values()) {
            if (power >= dice.getMinTotalPower() && power <= dice.getMaxTotalPower()) {
                return dice;
            }
        }
        return CharacterCombatDice.ZERO;
    }

    public boolean isDead() {
        return remainingFightingPower <= 0;
    }
}
