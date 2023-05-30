package vokorpgback.feature.commons.domain.model;

import java.util.Random;
import vokorpgback.feature.commons.domain.port.Dice;

public record GameDice(int numberOfFaces) implements Dice {

  @Override
  public int roll() {
    return new Random().nextInt(this.numberOfFaces) + 1;
  }
}
