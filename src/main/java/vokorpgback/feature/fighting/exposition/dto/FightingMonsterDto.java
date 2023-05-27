package vokorpgback.feature.fighting.exposition.dto;

public class FightingMonsterDto {
    private int maxFightingPower;
    private int remainingFightingPower;

    public FightingMonsterDto() {
    }

    public FightingMonsterDto(int maxFightingPower, int remainingFightingPower) {
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
