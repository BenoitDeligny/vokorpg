package vokorpgback.feature.commons.domain.model.dice;

import vokorpgback.feature.commons.domain.model.dice.Dice;

public record LoadedDice(int loadedValue) implements Dice {

    @Override
    public int roll() {
        return loadedValue;
    }
}
