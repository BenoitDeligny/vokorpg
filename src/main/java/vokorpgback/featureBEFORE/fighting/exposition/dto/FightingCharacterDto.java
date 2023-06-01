package vokorpgback.featureBEFORE.fighting.exposition.dto;

public class FightingCharacterDto {
    private int maxFightingPower;
    private int remainingFightingPower;
    private int agility;
    private boolean attemptToFlee;

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

    public void setMaxFightingPower(int fightingPower) {
        this.maxFightingPower = fightingPower;
    }

    public int getRemainingFightingPower() {
        return remainingFightingPower;
    }

    public void setRemainingFightingPower(int remainingFightingPower) {
        this.remainingFightingPower = remainingFightingPower;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public boolean attemptToFlee() {
        return attemptToFlee;
    }

    public void setAttemptToFlee(boolean attemptToFlee) {
        this.attemptToFlee = attemptToFlee;
    }
}
