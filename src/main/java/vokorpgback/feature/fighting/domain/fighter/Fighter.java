package vokorpgback.feature.fighting.domain.fighter;

import vokorpgback.feature.commons.domain.port.Dice;

import java.util.List;

public abstract class Fighter {
    private final int maxFightingPower;
    private final int remainingFightingPower;
    private final List<Dice> combatDice;

    protected Fighter(int maxFightingPower, int remainingFightingPower, List<Dice> dice) {
        this.maxFightingPower = maxFightingPower;
        this.remainingFightingPower = remainingFightingPower;
        this.combatDice = computeCombatDice(dice);
    }

    abstract List<Dice> computeCombatDice(List<Dice> dice);
    abstract int rollDamage();

    public boolean isDead() {
        return remainingFightingPower <= 0;
    };

    public int getMaxFightingPower() {
        return maxFightingPower;
    }

    public int getRemainingFightingPower() {
        return remainingFightingPower;
    }

    public List<Dice> getCombatDice() {
        return combatDice;
    }
}
