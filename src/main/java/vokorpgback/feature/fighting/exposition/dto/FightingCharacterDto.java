package vokorpgback.feature.fighting.exposition.dto;

public class FightingCharacterDto {
    private int maxFightingPower;
    private int remainingFightingPower;
    private int agility;

    public FightingCharacterDto() {
    }

    public FightingCharacterDto(int maxFightingPower, int remainingFightingPower, int agility) {
        this.maxFightingPower = maxFightingPower;
        this.remainingFightingPower = remainingFightingPower;
        this.agility = agility;
    }

    public int getMaxFightingPower() {
        return maxFightingPower;
    }

    public int getRemainingFightingPower() {
        return remainingFightingPower;
    }

    public int getAgility() {
        return agility;
    }

    public void setMaxFightingPower(int fightingPower) {
        this.maxFightingPower = fightingPower;
    }

    public void setRemainingFightingPower(int remainingFightingPower) {
        this.remainingFightingPower = remainingFightingPower;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}
