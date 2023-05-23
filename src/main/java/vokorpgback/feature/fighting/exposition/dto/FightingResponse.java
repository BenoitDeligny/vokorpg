package vokorpgback.feature.fighting.exposition.dto;

public class FightingResponse {
    private final String combatResult;
    private final int circumstanceModifier;
    private final int remainingMonsters;

    public FightingResponse(String combatResult, int circumstanceModifier, int remainingMonsters) {
        this.combatResult = combatResult;
        this.circumstanceModifier = circumstanceModifier;
        this.remainingMonsters = remainingMonsters;
    }
    public String getCombatResult() {
        return combatResult;
    }
    public int getCircumstanceModifier() {
        return circumstanceModifier;
    }
    public int getRemainingMonsters() {
        return remainingMonsters;
    }
}
