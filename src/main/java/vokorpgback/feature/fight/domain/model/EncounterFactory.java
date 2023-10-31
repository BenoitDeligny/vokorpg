package vokorpgback.feature.fight.domain.model;

import vokorpgback.feature.commons.domain.model.opponent.Opponent;
import vokorpgback.feature.commons.domain.model.opponent.OpponentFactory;
import vokorpgback.feature.commons.domain.model.dice.DiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EncounterFactory {

    private EncounterFactory() {
    }

    public static Encounter generateEncounter(Opponent opponentType, int opponentMaxMight, int numberOfOpponent, DiceFactory diceFactory) {
        List<Opponent> opponents = new ArrayList<>();

        for (int i = 0; i < numberOfOpponent; i++) {
            opponents.add(OpponentFactory.generateOpponent(opponentType.name(), opponentMaxMight, diceFactory));
        }

        return new Encounter(Map.of(true, opponents, false, new ArrayList<>()), diceFactory.createDice(6));
    }
}
