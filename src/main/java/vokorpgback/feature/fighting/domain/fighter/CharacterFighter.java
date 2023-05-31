package vokorpgback.feature.fighting.domain.fighter;

import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.feature.fighting.domain.combatchart.CharacterCombatChart;

public class CharacterFighter extends Fighter {
    private final int agility;
    private final CharacterCombatChart combatChart;

    public CharacterFighter(int maxFightingPower, int remainingFightingPower, int agility) {
        super(maxFightingPower, remainingFightingPower);
        this.agility = agility;
        this.combatChart = computeCombatChart(maxFightingPower);
    }

    public CharacterFighter(int maxFightingPower, int remainingFightingPower, int agility, Dice diceType) {
        super(maxFightingPower, remainingFightingPower, diceType);
        this.agility = agility;
        this.combatChart = computeCombatChart(maxFightingPower);
    }

    private CharacterCombatChart computeCombatChart(int maxFightingPower) {
        for (CharacterCombatChart characterCombatChart : CharacterCombatChart.values()) {
            if (maxFightingPower >= characterCombatChart.getMinTotalPower() && maxFightingPower <= characterCombatChart.getMaxTotalPower()) {
                return characterCombatChart;
            }
        }
        return CharacterCombatChart.ZERO;
    }

    @Override
    public int rollDamage() {
        int totalDamages = 0;

        if (combatChart.equals(CharacterCombatChart.ZERO)) {
            return 1;
        }

        for (int i = 0; i < combatChart.getNumberOfDice(); i++) {
            totalDamages += getCombatDice().roll();
        }

        return totalDamages;
    }

    public int getAgility() {
        return agility;
    }
}
