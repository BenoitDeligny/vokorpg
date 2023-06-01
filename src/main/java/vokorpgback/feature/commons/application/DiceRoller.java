package vokorpgback.feature.commons.application;

import vokorpgback.feature.commons.domain.port.Dice;

public abstract class DiceRoller {
    public abstract Dice createDice(int value);
}
