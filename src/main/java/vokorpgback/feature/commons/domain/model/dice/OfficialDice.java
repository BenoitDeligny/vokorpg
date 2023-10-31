package vokorpgback.feature.commons.domain.model.dice;

import java.util.Random;

public record OfficialDice(int numberOfFaces) implements Dice {

    @Override
    public int roll() {
        return new Random().nextInt(this.numberOfFaces) + 1;
    }
}
