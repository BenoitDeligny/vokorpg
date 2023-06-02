package vokorpgback.feature.commons.application;

import vokorpgback.feature.commons.domain.port.Dice;

public abstract class DiceFactory {
    public int rollDice(int value) {
        Dice dice = createDice();
        dice.roll();
    }

    Dice createDice(int value);
}
