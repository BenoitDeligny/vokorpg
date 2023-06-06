package vokorpgback.feature.character.domain.model;

import vokorpgback.feature.character.domain.model.ability.AbilityFactory;
import vokorpgback.feature.character.domain.model.ability.Agility;
import vokorpgback.feature.character.domain.model.ability.Perception;
import vokorpgback.feature.character.domain.model.ability.Strength;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

public class LegendaryCharacterFactory {

    private LegendaryCharacterFactory() {
    }

    public static LegendaryCharacter generateLegendaryCharacter(GameMode gameMode, Dice dice, String name) {
        Strength strength = generateStrength(gameMode, dice);
        Agility agility = generateAgility(gameMode, dice);
        Perception perception = generatePerception(gameMode, dice);

        return new LegendaryCharacter(
                name,
                generateAge(dice),
                strength,
                agility,
                perception,
                computeTotalPower(strength, agility, perception),
                generateGear()
        );
    }

    private static int generateAge(Dice dice) {
        return dice.roll() + 14;
    }

    private static Strength generateStrength(GameMode gameMode, Dice dice) {
        return AbilityFactory.generateStrength(gameMode, dice);
    }

    private static Agility generateAgility(GameMode gameMode, Dice dice) {
        return AbilityFactory.generateAgility(gameMode, dice);
    }

    private static Perception generatePerception(GameMode gameMode, Dice dice) {
        return AbilityFactory.generatePerception(gameMode, dice);
    }

    private static int computeTotalPower(Strength strength, Agility agility, Perception perception) {
        return strength.value() +
                agility.value() +
                perception.value();
    }

    private static Gear generateGear() {
        return null;
    }
}
