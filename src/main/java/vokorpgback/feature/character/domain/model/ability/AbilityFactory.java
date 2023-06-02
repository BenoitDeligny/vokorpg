package vokorpgback.feature.character.domain.model.ability;


import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

public class AbilityFactory {

    private final GameMode gameMode;

    public AbilityFactory(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public Strength generateStrength(Dice dice) {
        return new Strength(dice.roll() + gameMode.getAbilitiesModifier());
    }

    public Agility generateAgility(Dice dice) {
        return new Agility(dice.roll() + gameMode.getAbilitiesModifier());
    }

    public Perception generatePerception(Dice dice) {
        return new Perception(dice.roll() + gameMode.getAbilitiesModifier());
    }
}
