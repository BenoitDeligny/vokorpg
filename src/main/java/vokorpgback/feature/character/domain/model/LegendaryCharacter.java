package vokorpgback.feature.character.domain.model;

import vokorpgback.commons.Validation;
import vokorpgback.feature.character.domain.model.ability.Abilities;
import vokorpgback.feature.character.domain.model.gear.Gear;
import vokorpgback.feature.commons.domain.model.GameDice;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

// TODO
// it will be soon at feature level
public record LegendaryCharacter(
        String name, int age, Abilities abilities, int totalPower, Gear gear) {

    public LegendaryCharacter {
        Validation.require(isAgeBetween14And20(age), "Age must be between 15 and 20.");
        Validation.require(
                isTotalPowerSumOfAbilities(totalPower, abilities),
                "TotalPower is not equal to the sum of abilities values.");
    }

    public static LegendaryCharacter generateCharacter(String name, GameMode gameMode) {
        Dice dice = new GameDice(6);

        Abilities abilities = Abilities.generateAbilities(gameMode, dice);

        return new LegendaryCharacter(
                name,
                computeAge(dice.roll()),
                abilities,
                computeTotalPower(abilities),
                Gear.generateDefaultGear(gameMode));
    }

    private static int computeAge(int diceRoll) {
        return diceRoll + 14;
    }

    private static int computeTotalPower(Abilities abilities) {
        return abilities.strength().value()
                + abilities.agility().value()
                + abilities.perception().value();
    }

    private boolean isAgeBetween14And20(int age) {
        return age >= 15 && age <= 20;
    }

    private boolean isTotalPowerSumOfAbilities(int totalPower, Abilities abilities) {
        return totalPower == abilities.computeSumOfAbilities();
    }
}
