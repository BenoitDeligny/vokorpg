package vokorpgback.feature.action.domain;

public record CharacterActionScore(
        int firstRoll,
        int secondRoll,
        int abilityScore,
        int knowledgeScore
) {

    public int computeTotalScore() {
        return firstRoll + secondRoll + abilityScore + knowledgeScore;
    }
}
