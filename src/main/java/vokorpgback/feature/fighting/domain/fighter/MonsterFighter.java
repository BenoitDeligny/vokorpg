package vokorpgback.feature.fighting.domain.fighter;

import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.feature.fighting.domain.combatchart.MonsterCombatChart;

import java.util.ArrayList;
import java.util.List;

public class MonsterFighter extends Fighter {
    private final MonsterCombatChart combatChart;

    public MonsterFighter(int maxFightingPower, int remainingFightingPower, List<Dice> dice) {
        super(maxFightingPower, remainingFightingPower, dice);
        this.combatChart = computeCombatChart(maxFightingPower);
    }

    private MonsterCombatChart computeCombatChart(int maxFightingPower) {
        for (MonsterCombatChart dice : MonsterCombatChart.values()) {
            if (maxFightingPower >= dice.getMinTotalPower() && maxFightingPower <= dice.getMaxTotalPower()) {
                return dice;
            }
        }
        return MonsterCombatChart.ZERO;
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

        if (combatChart.equals(MonsterCombatChart.ZERO)) {
            return 1;
        }

        for (int i = 0; i < getCombatDice().size(); i++) {
            totalDamages += getCombatDice().get(i).roll();
        }

        return totalDamages;
    }
}
