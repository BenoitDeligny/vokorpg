package vokorpgback.feature.commons.domain.model;

import vokorpgback.feature.commons.domain.port.Dice;

import java.util.Random;

public record GameDice(int numberOfFaces) implements Dice {

    @Override
    public int roll() {
        return new Random().nextInt(this.numberOfFaces) + 1;
    }
}
