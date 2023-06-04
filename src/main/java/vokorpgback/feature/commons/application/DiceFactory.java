package vokorpgback.feature.commons.application;

import vokorpgback.feature.commons.domain.port.Dice;

public abstract class DiceFactory {
    public int rollDice(int value) {
        Dice dice = createDice(value);
        return dice.roll();
    }

    abstract Dice createDice(int value);
}
