package vokorpgback.feature.commons.domain.model.opponent;

import vokorpgback.feature.commons.domain.model.dice.Dice;

import java.util.UUID;

public class Opponent {
        private final UUID uuid;
        private final String name;
        private OpponentFightingMight fightingMight;
        private final Dice diceType;
        // TODO add specialization (damages, rules, ...)


    protected Opponent(UUID uuid, String name, OpponentFightingMight fightingMight, Dice diceType) {
        this.uuid = uuid;
        this.name = name;
        this.fightingMight = fightingMight;
        this.diceType = diceType;
    }

    public int rollDamages() {
        int damages = 0;

        for (int i = 0; i < fightingMight.combatChart.getNumberOfDice(); i++) {
            damages += diceType.roll();
        }

        return damages;
    }

    public void takeDamages(int characterDamages) {
        this.fightingMight = new OpponentFightingMight(fightingMight.maxNaturalMight(), fightingMight.remainingMight() - characterDamages, fightingMight.combatChart);
    }

    public boolean isDead() {
        return fightingMight.remainingMight() <= 0;
    }

    public OpponentFightingMight fightingMight() {
        return fightingMight;
    }

    public String name() {
        return name;
    }
}
