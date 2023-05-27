package vokorpgback.feature.fighting.domain.fighter;

import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.feature.fighting.domain.combatchart.MonsterCombatChart;

public class MonsterFighter extends Fighter {
    private final MonsterCombatChart combatChart;

    public MonsterFighter(int maxFightingPower, int remainingFightingPower) {
        super(maxFightingPower, remainingFightingPower);
        this.combatChart = computeCombatChart(maxFightingPower);
    }

    public MonsterFighter(int maxFightingPower, int remainingFightingPower, Dice diceType) {
        super(maxFightingPower, remainingFightingPower, diceType);
        this.combatChart = computeCombatChart(maxFightingPower);
    }

    private MonsterCombatChart computeCombatChart(int maxFightingPower) {
        for (MonsterCombatChart monsterCombatChart : MonsterCombatChart.values()) {
            if (maxFightingPower >= monsterCombatChart.getMinTotalPower()
                    && maxFightingPower <= monsterCombatChart.getMaxTotalPower()) {
                return monsterCombatChart;
            }
        }
        return MonsterCombatChart.ZERO;
    }

    @Override
    public int rollDamage() {
        int totalDamages = 0;

        if (combatChart.equals(MonsterCombatChart.ZERO)) {
            return 1;
        }

        for (int i = 0; i < combatChart.getNumberOfDice(); i++) {
            totalDamages += getCombatDice().roll();
        }

        return totalDamages;
    }
}
