package vokorpgback.feature.character.domain.model;

import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

public record Ability(
        int value) {

    public boolean isPositive() {
        return value > 0;
    }

    public static Ability generateAbility(GameMode gameMode, Dice dice) {
        return new Ability(dice.roll() + gameMode.getAbilitiesModifier());
    }
}
