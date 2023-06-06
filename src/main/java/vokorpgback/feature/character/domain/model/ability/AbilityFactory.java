package vokorpgback.feature.character.domain.model.ability;


import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

public class AbilityFactory {

    private AbilityFactory() {
    }

    public static Strength generateStrength(GameMode gameMode, Dice dice) {
        return new Strength(gameMode.getAbilitiesModifier() + dice.roll());
    }

    public static Agility generateAgility(GameMode gameMode, Dice dice) {
        return new Agility(gameMode.getAbilitiesModifier() + dice.roll());
    }

    public static Perception generatePerception(GameMode gameMode, Dice dice) {
        return new Perception(gameMode.getAbilitiesModifier() + dice.roll());
    }
}
