package vokorpgback.feature.fighting.exposition.dto;

public class FightingMonsterDto {
    private int maxFightingPower;
    private int remainingFightingPower;
    private int damageDice;

    public int getMaxFightingPower() {
        return maxFightingPower;
    }
    
    public int getRemainingFightingPower() {
        return remainingFightingPower;
    }

    public int getDamageDice() {
        return damageDice;
    }

    public void setMaxFightingPower(int fightingPower) {
        this.maxFightingPower = fightingPower;
    }

    public void setRemainingFightingPower(int remainingFightingPower) {
        this.remainingFightingPower = remainingFightingPower;
    }

    public void setDamageDice(int damageDice) {
        this.damageDice = damageDice;
    }
}
