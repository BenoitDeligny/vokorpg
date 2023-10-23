package vokorpgback.feature.commons.domain.model.character;

import vokorpgback.feature.commons.domain.model.might.FightingMight;
import vokorpgback.feature.commons.domain.model.opponent.OpponentCombatChart;

public class CharacterFightingMight extends FightingMight {
    int maxTotalMight;
    CharacterCombatChart combatChart;

    public CharacterFightingMight(int maxNaturalMight, int maxTotalMight, int remainingMight, CharacterCombatChart opponentCombatChart) {
        super(maxNaturalMight, remainingMight);
        this.maxTotalMight = maxTotalMight;
        this.combatChart = opponentCombatChart;
    }

    public int maxTotalMight() {
        return maxTotalMight;
    }

    public CharacterCombatChart characterCombatChart() {
        return combatChart;
    }
}
