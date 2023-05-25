package vokorpgback.feature.fighting.exposition.dto;

public class FightingCharacterDto {
    private int maxFightingPower;
    private int remainingFightingPower;

    public FightingCharacterDto() {
    }

    public FightingCharacterDto(int maxFightingPower, int remainingFightingPower) {
        this.maxFightingPower = maxFightingPower;
        this.remainingFightingPower = remainingFightingPower;
    }

    public int getMaxFightingPower() {
        return maxFightingPower;
    }
    
    public int getRemainingFightingPower() {
        return remainingFightingPower;
    }

    public void setMaxFightingPower(int fightingPower) {
        this.maxFightingPower = fightingPower;
    }

    public void setRemainingFightingPower(int remainingFightingPower) {
        this.remainingFightingPower = remainingFightingPower;
    }    
}
