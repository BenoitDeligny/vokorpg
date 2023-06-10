package vokorpgback.feature.commons.domain.model;

import vokorpgback.feature.commons.domain.model.LoadedDice;
import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.feature.commons.domain.port.DiceFactory;

public class LoadedDiceFactory implements DiceFactory {
    @Override
    public Dice createDice(int loadedValue) {
        return new LoadedDice(loadedValue);
    }
}
