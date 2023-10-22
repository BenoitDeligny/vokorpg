package vokorpgback.feature.fight.domain.model;

public class EncounterFactory {

    private EncounterFactory() {
    }

    public static Encounter generateEncounter(int numberOfOpponent, Opponent opponentType) {
        return new Encounter(numberOfOpponent, opponentType);
    }
}
