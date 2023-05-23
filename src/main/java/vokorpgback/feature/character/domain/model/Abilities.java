package vokorpgback.feature.character.domain.model;

import vokorpgback.commons.Validation;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

public record Abilities(
                Ability strength,
                Ability agility,
                Ability perception) {

        public Abilities {
                Validation.require(strength.isPositive(), "Strength must be positive.");
                Validation.require(agility.isPositive(), "Agility must be positive.");
                Validation.require(perception.isPositive(), "Perception must be positive.");
        }

        public static Abilities generateAbilities(GameMode gameMode, Dice dice) {
                return new Abilities(
                                Ability.generateAbility(gameMode, dice),
                                Ability.generateAbility(gameMode, dice),
                                Ability.generateAbility(gameMode, dice));
        }
}
