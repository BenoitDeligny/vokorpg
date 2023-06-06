package vokorpgback.feature.commons.application;

import vokorpgback.feature.commons.domain.model.LoadedDice;
import vokorpgback.feature.commons.domain.port.Dice;

public class LoadedDiceFactory implements DiceFactory {
    @Override
    public Dice createDice(int loadedValue) {
        return new LoadedDice(loadedValue);
    }
}
