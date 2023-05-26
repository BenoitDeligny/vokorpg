package vokorpgback.feature.fighting.domain.fighter;

import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.feature.fighting.domain.combatchart.CharacterCombatChart;

import java.util.ArrayList;
import java.util.List;

public class CharacterFighter extends Fighter {
    private final int agility;
    private final CharacterCombatChart combatChart;

    public CharacterFighter(int maxFightingPower, int remainingFightingPower, int agility, List<Dice> dice) {
        super(maxFightingPower, remainingFightingPower, dice);
        this.agility = agility;
        this.combatChart = computeCombatChart(maxFightingPower);
    }

    private CharacterCombatChart computeCombatChart(int maxFightingPower) {
        for (CharacterCombatChart dice : CharacterCombatChart.values()) {
            if (maxFightingPower >= dice.getMinTotalPower() && maxFightingPower <= dice.getMaxTotalPower()) {
                return dice;
            }
        }
        return CharacterCombatChart.ZERO;
    }

    @Override
    List<Dice> computeCombatDice(List<Dice> dice) {
        List<Dice> combatDice = new ArrayList<>();
        int numberOfDice = combatChart.getNumberOfDice();

        for (int i = 1; i < numberOfDice; i++) {
            combatDice.add(dice.get(i));
        }

        return combatDice;
    }

    @Override
    int rollDamage() {
        int totalDamages = 0;

        if (combatChart.equals(CharacterCombatChart.ZERO)) {
            return 1;
        }

        for (int i = 0; i < getCombatDice().size(); i++) {
            totalDamages += getCombatDice().get(i).roll();
        }

        return totalDamages;
    }
}