package vokorpgback.feature.character.domain.model.ability;

import vokorpgback.feature.commons.domain.port.Dice;

public class AbilitiesFactory {
    private final AbilityFactory abilityFactory;

    public AbilitiesFactory(AbilityFactory abilityFactory) {
        this.abilityFactory = abilityFactory;
    }

    public Abilities buildNormalModeAbilities(Dice dice) {
        return new Abilities(
                abilityFactory.generateStrength(dice.roll()),
                abilityFactory.generateAgility(dice.roll()),
                abilityFactory.generatePerception(dice.roll())
        );
    }

    public Abilities buildEasyModeAbilities(Dice dice) {
        return new Abilities(
                abilityFactory.generateStrength(dice.roll()),
                abilityFactory.generateAgility(dice.roll()),
                abilityFactory.generatePerception(dice.roll())
        );
    }
}
