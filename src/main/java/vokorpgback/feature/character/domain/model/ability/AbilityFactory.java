package vokorpgback.feature.character.domain.model.ability;


import vokorpgback.feature.commons.domain.model.GameMode;

public class AbilityFactory {

    private GameMode gameMode;

    public AbilityFactory(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public Strength generateStrength(int diceRoll) {
        return new Strength(diceRoll + gameMode.getAbilitiesModifier());
    }

    public Agility generateAgility(int diceRoll) {
        return new Agility(diceRoll + gameMode.getAbilitiesModifier());
    }

    public Perception generatePerception(int diceRoll) {
        return new Perception(diceRoll + gameMode.getAbilitiesModifier());
    }
}
