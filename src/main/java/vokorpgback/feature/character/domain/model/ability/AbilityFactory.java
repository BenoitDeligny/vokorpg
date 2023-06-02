package vokorpgback.feature.character.domain.model.ability;


import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

public class AbilityFactory {

    private final GameMode gameMode;
    private final Dice dice;

    public AbilityFactory(GameMode gameMode, Dice dice) {
        this.gameMode = gameMode;
        this.dice = dice;
    }

    public Strength generateStrength() {
        return new Strength(dice.roll() + gameMode.getAbilitiesModifier());
    }

    public Agility generateAgility() {
        return new Agility(dice.roll() + gameMode.getAbilitiesModifier());
    }

    public Perception generatePerception() {
        return new Perception(dice.roll() + gameMode.getAbilitiesModifier());
    }
}
