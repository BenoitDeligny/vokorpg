package vokorpgback.feature.commons.application;

import vokorpgback.feature.commons.domain.model.OfficialDice;
import vokorpgback.feature.commons.domain.port.Dice;

public class OfficialDiceFactory extends DiceFactory {
    @Override
    public Dice createDice(int numberOfFaces) {
        return new OfficialDice(numberOfFaces);
    }
}
