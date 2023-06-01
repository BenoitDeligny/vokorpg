package vokorpgback.feature.commons.domain.model;

import vokorpgback.feature.commons.domain.port.Dice;

public record LoadedDice(int loadedValue) implements Dice {

    @Override
    public int roll() {
        return loadedValue;
    }
}
