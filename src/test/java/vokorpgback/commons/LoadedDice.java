package vokorpgback.commons;

import vokorpgback.feature.commons.domain.port.Dice;

public record LoadedDice(int loadedValue) implements Dice {

    @Override
    public int roll() {
        return loadedValue;
    }
}
