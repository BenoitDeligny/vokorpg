package vokorpgback.feature.commons.domain.model.opponent;

import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.feature.commons.domain.port.DiceFactory;

import java.util.UUID;

public class OpponentFactory {

    private OpponentFactory() {
    }

    public static Opponent generateOpponent(String name, int maxTotalMight, DiceFactory diceFactory) {
        // UUID
        UUID uuid = UUID.randomUUID();

        // Might
        OpponentFightingMight fightingMight = new OpponentFightingMight(maxTotalMight, maxTotalMight, computeCombatChart(maxTotalMight));

        // Dice
        Dice diceType = diceFactory.createDice(6);

        return new Opponent(uuid, name, fightingMight, diceType);
    }

    private static OpponentCombatChart computeCombatChart(int maxFightingMight) {
        for (OpponentCombatChart opponentCombatChart : OpponentCombatChart.values()) {
            if (maxFightingMight >= opponentCombatChart.getMinTotalMight() && maxFightingMight <= opponentCombatChart.getMaxTotalMight()) {
                return opponentCombatChart;
            }
        }
        return OpponentCombatChart.ZERO;
    }
}
