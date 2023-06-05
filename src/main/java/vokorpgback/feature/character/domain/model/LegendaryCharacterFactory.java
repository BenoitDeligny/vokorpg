package vokorpgback.feature.character.domain.model;

import vokorpgback.feature.character.domain.model.ability.AbilityFactory;
import vokorpgback.feature.character.domain.model.ability.Agility;
import vokorpgback.feature.character.domain.model.ability.Perception;
import vokorpgback.feature.character.domain.model.ability.Strength;
import vokorpgback.feature.commons.application.DiceFactory;
import vokorpgback.feature.commons.domain.model.GameMode;

public class LegendaryCharacterFactory {

    private final DiceFactory diceFactory;

    public LegendaryCharacterFactory(DiceFactory diceFactory) {
        this.diceFactory = diceFactory;
    }

    // TODO
    // factory with private constructor -> method static
    public LegendaryCharacter generateLegendaryCharacter(GameMode gameMode, String name) {
        AbilityFactory abilityFactory = new AbilityFactory(gameMode);

        Strength strength = abilityFactory.generateStrength(diceFactory.rollDice(6));
        Agility agility = abilityFactory.generateAgility(diceFactory.rollDice(6));
        Perception perception = abilityFactory.generatePerception(diceFactory.rollDice(6));

        return new LegendaryCharacter(
                name,
                generateAge(),
                strength,
                agility,
                perception,
                computeTotalPower(strength, agility, perception),
                generateGear()
        );
    }

    private int generateAge() {
        return diceFactory.rollDice(6) + 14;
    }

    private int computeTotalPower(Strength strength, Agility agility, Perception perception) {
        return strength.value() +
                agility.value() +
                perception.value();
    }

    private Gear generateGear() {
        return null;
    }
}
