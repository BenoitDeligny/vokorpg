package vokorpgback.feature.fight.domain.model;

import vokorpgback.feature.commons.domain.model.opponent.Opponent;

public class EncounterFactory {

    private EncounterFactory() {
    }

    public static Encounter generateEncounter(int numberOfOpponent, Opponent opponentType) {
        return new Encounter(numberOfOpponent, opponentType);
    }
}
