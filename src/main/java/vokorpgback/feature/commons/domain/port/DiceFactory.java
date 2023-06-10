package vokorpgback.feature.commons.domain.port;

import vokorpgback.feature.commons.domain.port.Dice;

public interface DiceFactory {
    Dice createDice(int value);
}
