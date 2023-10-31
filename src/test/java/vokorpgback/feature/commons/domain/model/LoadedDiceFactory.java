package vokorpgback.feature.commons.domain.model;

import vokorpgback.feature.commons.domain.model.dice.Dice;
import vokorpgback.feature.commons.domain.model.dice.DiceFactory;

public class LoadedDiceFactory implements DiceFactory {
    @Override
    public Dice createDice(int loadedValue) {
        return new LoadedDice(loadedValue);
    }
}
