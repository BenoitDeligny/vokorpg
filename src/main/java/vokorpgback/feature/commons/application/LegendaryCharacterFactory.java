package vokorpgback.feature.commons.application;

import vokorpgback.feature.commons.domain.model.*;
import vokorpgback.feature.commons.domain.model.ability.Agility;
import vokorpgback.feature.commons.domain.model.ability.Perception;
import vokorpgback.feature.commons.domain.model.ability.Strength;
import vokorpgback.feature.commons.domain.model.item.*;
import vokorpgback.feature.commons.domain.port.Dice;

import java.util.UUID;

import static java.util.Collections.emptyList;
import static vokorpgback.feature.commons.application.GearFactory.generateGear;

public class LegendaryCharacterFactory {

    private LegendaryCharacterFactory() {
    }

    public static LegendaryCharacter generateLegendaryCharacter(GameMode gameMode, DiceFactory diceFactory, String name) {
        // identity
        Identity identity = new Identity(UUID.randomUUID(), name, generateAge(diceFactory.createDice(6)));

        // ability
        Strength strength = new Strength(generateAbilityScore(gameMode, diceFactory.createDice(6)));
        Agility agility = new Agility(generateAbilityScore(gameMode, diceFactory.createDice(6)));
        Perception perception = new Perception(generateAbilityScore(gameMode, diceFactory.createDice(6)));

        // gear
        Gear gear = generateGear(gameMode);

        // power and dice
        Power power = computePower(strength, agility, perception);

        return new LegendaryCharacter(
                identity,
                strength,
                agility,
                perception,
                gear,
                power
        );
    }

    private static int generateAge(Dice dice) {
        return dice.roll() + 14;
    }

    private static int generateAbilityScore(GameMode gameMode, Dice dice) {
        return gameMode.getAbilitiesModifier() + dice.roll();
    }

    private static Power computePower(Strength strength, Agility agility, Perception perception) {
        int maxNaturalPower = strength.value() + agility.value() + perception.value();
        int maxTotalPower = strength.value() + agility.value() + perception.value(); // TODO add items, knowledge, powers bonus

        return new Power(
                maxNaturalPower,
                maxTotalPower,
                maxTotalPower,
                computeCombatChart(maxTotalPower)
        );
    }

    private static CharacterCombatChart computeCombatChart(int maxFightingPower) {
        for (CharacterCombatChart characterCombatChart : CharacterCombatChart.values()) {
            if (maxFightingPower >= characterCombatChart.getMinTotalPower() && maxFightingPower <= characterCombatChart.getMaxTotalPower()) {
                return characterCombatChart;
            }
        }
        return CharacterCombatChart.ZERO;
    }
}
