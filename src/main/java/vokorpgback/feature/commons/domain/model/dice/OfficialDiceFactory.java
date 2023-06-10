package vokorpgback.feature.commons.domain.model.dice;

import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.feature.commons.domain.port.DiceFactory;

public class OfficialDiceFactory implements DiceFactory {
    @Override
    public Dice createDice(int numberOfFaces) {
        return new OfficialDice(numberOfFaces);
    }
}
