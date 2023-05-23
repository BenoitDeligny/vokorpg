package vokorpgback.feature.fighting.exposition.dto;

public class FightingCharacterDto {
    private int maxFightingPower;
    private int remainingFightingPower;
    private int damageDices;

    public int getMaxFightingPower() {
        return maxFightingPower;
    }
    
    public int getRemainingFightingPower() {
        return remainingFightingPower;
    }
    
    public int getDamageDices() {
        return damageDices;
    }

    public void setMaxFightingPower(int fightingPower) {
        this.maxFightingPower = fightingPower;
    }
    
    public void setDamageDices(int damageDices) {
        this.damageDices = damageDices;
    }

    public void setRemainingFightingPower(int remainingFightingPower) {
        this.remainingFightingPower = remainingFightingPower;
    }    
}
