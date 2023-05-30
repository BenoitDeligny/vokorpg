package vokorpgback.feature.character.domain.model.ability;

import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

public record Ability(
        int value) {

    public static Ability generateAbility(Dice dice, GameMode gameMode) {
        return new Ability(dice.roll() + gameMode.getAbilitiesModifier());
    }

    public boolean isPositive() {
        return value > 0;
    }
}
