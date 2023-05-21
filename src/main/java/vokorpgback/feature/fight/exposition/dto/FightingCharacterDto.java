package vokorpgback.feature.fight.exposition.dto;

public class FightingCharacterDto {
    private int fightingPower;
    private int circumstanceModifier;

    public int getFightingPower() {
        return fightingPower;
    }

    public int getCircumstanceModifier() {
        return circumstanceModifier;
    }

    public void setFightingPower(int fightingPower) {
        this.fightingPower = fightingPower;
    }

    public void setCircumstanceModifier(int circumstanceModifier) {
        this.circumstanceModifier = circumstanceModifier;
    }
    
}
