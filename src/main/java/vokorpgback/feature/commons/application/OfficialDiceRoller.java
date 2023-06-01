package vokorpgback.feature.commons.application;

import vokorpgback.feature.commons.domain.model.OfficialDice;
import vokorpgback.feature.commons.domain.port.Dice;

public class OfficialDiceRoller extends DiceRoller {
    @Override
    public Dice createDice(int numberOfFaces) {
        return new OfficialDice(numberOfFaces);
    }
}
