package vokorpgback.feature.commons.domain.model.opponent;

import vokorpgback.feature.commons.domain.model.might.FightingMight;

public class OpponentFightingMight extends FightingMight {
    OpponentCombatChart combatChart;

    public OpponentFightingMight(int maxNaturalMight, int remainingMight, OpponentCombatChart opponentCombatChart) {
        super(maxNaturalMight, remainingMight);
        this.combatChart = opponentCombatChart;
    }
}
