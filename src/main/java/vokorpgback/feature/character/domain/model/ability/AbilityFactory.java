package vokorpgback.feature.character.domain.model.ability;


import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

public class AbilityFactory {

    private final GameMode gameMode;

    public AbilityFactory(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public Strength generateStrength(int roll) {
        return new Strength(roll + gameMode.getAbilitiesModifier());
    }

    public Agility generateAgility(int roll) {
        return new Agility(roll + gameMode.getAbilitiesModifier());
    }

    public Perception generatePerception(int roll) {
        return new Perception(roll + gameMode.getAbilitiesModifier());
    }
}
