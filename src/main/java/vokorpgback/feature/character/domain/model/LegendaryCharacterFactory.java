package vokorpgback.feature.character.domain.model;

import vokorpgback.feature.character.domain.model.ability.AbilityFactory;
import vokorpgback.feature.character.domain.model.ability.Agility;
import vokorpgback.feature.character.domain.model.ability.Perception;
import vokorpgback.feature.character.domain.model.ability.Strength;
import vokorpgback.feature.commons.application.DiceFactory;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.featureBEFORE.character.domain.model.gear.Gear;

public class LegendaryCharacterFactory {

    private final DiceFactory diceFactory;

    public LegendaryCharacterFactory(DiceFactory diceFactory) {
        this.diceFactory = diceFactory;
    }

    public LegendaryCharacter generateLegendaryCharacter(GameMode gameMode, String name) {
        Dice dice = diceFactory.createDice(6);
        AbilityFactory abilityFactory = new AbilityFactory(gameMode, dice);

        Strength strength = abilityFactory.generateStrength();
        Agility agility = abilityFactory.generateAgility();
        Perception perception = abilityFactory.generatePerception();

        return new LegendaryCharacter(
                name,
                generateAge(dice.roll()),
                strength,
                agility,
                perception,
                computeTotalPower(strength, agility, perception),
                generateGear()
        );
    }

    private int generateAge(int diceRoll) {
        return diceRoll + 14;
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
