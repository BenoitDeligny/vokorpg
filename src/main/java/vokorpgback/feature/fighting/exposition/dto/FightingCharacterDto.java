package vokorpgback.feature.fighting.exposition.dto;

public class FightingCharacterDto {
    private int fightingPower;
    private int agility;
    private int circumstanceModifier;

    public int getFightingPower() {
        return fightingPower;
    }
    
    public int getAgility() {
        return agility;
    }

    public int getCircumstanceModifier() {
        return circumstanceModifier;
    }

    public void setFightingPower(int fightingPower) {
        this.fightingPower = fightingPower;
    }
    
    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setCircumstanceModifier(int circumstanceModifier) {
        this.circumstanceModifier = circumstanceModifier;
    }
}
