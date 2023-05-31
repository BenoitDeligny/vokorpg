package vokorpgback.feature.fighting.domain.fighter;

import vokorpgback.feature.commons.domain.port.Dice;

public abstract class Fighter {
    private final int maxFightingPower;
    private final int remainingFightingPower;
    private Dice combatDice;

    protected Fighter(int maxFightingPower, int remainingFightingPower) {
        this.maxFightingPower = maxFightingPower;
        this.remainingFightingPower = remainingFightingPower;
    }

    protected Fighter(int maxFightingPower, int remainingFightingPower, Dice diceType) {
        this.maxFightingPower = maxFightingPower;
        this.remainingFightingPower = remainingFightingPower;
        this.combatDice = diceType;
    }

    abstract int rollDamage();

    public boolean isDead() {
        return remainingFightingPower <= 0;
    }

    ;

    public int getMaxFightingPower() {
        return maxFightingPower;
    }

    public int getRemainingFightingPower() {
        return remainingFightingPower;
    }

    public Dice getCombatDice() {
        return combatDice;
    }
}
