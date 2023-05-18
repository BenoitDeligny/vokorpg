package vokorpgback.fight.exposition.dto;

import java.util.Random;

public class FightingCharacterDto {
    private int fightingPower;
    private int circumstanceModifier;

    public int computeTotalFightingPower() {
        return fightingPower + getAttackRoll() + circumstanceModifier;
    }

    private int getAttackRoll() {
        Random roll = new Random();
        return roll.nextInt(6) + 1;
    }

    public int getFightingPower() {
        return fightingPower;
    }
    public int getCircumstanceModifier() {
        return circumstanceModifier;
    }
}
