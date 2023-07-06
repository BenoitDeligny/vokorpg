package vokorpgback.feature.commons.domain.model.character;

import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.Power;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter.Ability;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter.Identity;
import vokorpgback.feature.commons.domain.model.character.gear.BackPack;
import vokorpgback.feature.commons.domain.model.character.gear.Gear;
import vokorpgback.feature.commons.domain.model.knowledge.Knowledge;
import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.feature.commons.domain.port.DiceFactory;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static vokorpgback.feature.commons.domain.model.character.gear.BackPackFactory.generateBackPack;
import static vokorpgback.feature.commons.domain.model.character.gear.GearFactory.generateBasicGear;


public class LegendaryCharacterFactory {

    private LegendaryCharacterFactory() {
    }

    public static LegendaryCharacter generateLegendaryCharacter(GameMode gameMode, DiceFactory diceFactory, String name) {
        // identity
        Identity identity = new Identity(name, generateAge(diceFactory.createDice(6)));

        // ability
        Ability strength = new Ability(generateAbilityScore(gameMode, diceFactory.createDice(6)));
        Ability agility = new Ability(generateAbilityScore(gameMode, diceFactory.createDice(6)));
        Ability perception = new Ability(generateAbilityScore(gameMode, diceFactory.createDice(6)));

        // powers
        List<Power> powers = Collections.emptyList();

        // knowledge
        List<Knowledge> knowledge = Collections.emptyList();

        // gear
        Gear gear = generateBasicGear(gameMode);

        // backPack
        BackPack backPack = generateBackPack(gameMode);

        return new LegendaryCharacter(
                identity,
                strength,
                agility,
                perception,
                gear,
                powers,
                knowledge,
                backPack
        );
    }

    private static int generateAge(Dice dice) {
        return dice.roll() + 14;
    }

    private static int generateAbilityScore(GameMode gameMode, Dice dice) {
        return gameMode.getAbilitiesModifier() + dice.roll();
    }
}
