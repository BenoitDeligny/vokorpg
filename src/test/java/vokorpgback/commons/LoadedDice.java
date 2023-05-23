package vokorpgback.commons;

import java.util.Random;

import vokorpgback.feature.commons.domain.port.Dice;

public record LoadedDice(
        int seed) implements Dice {

    @Override
    public int roll() {
        return new Random(seed).nextInt(6);
    }

}
