package vokorpgback.feature.character.domain.model;

import vokorpgback.commons.Validation;
import vokorpgback.feature.character.domain.model.ability.Agility;
import vokorpgback.feature.character.domain.model.ability.Perception;
import vokorpgback.feature.character.domain.model.ability.Strength;
import vokorpgback.feature.character.domain.model.gear.Gear;

public record LegendaryCharacter(
        String name,
        int age,
        Strength strength,
        Agility agility,
        Perception perception,
        int totalPower,
        Gear gear
) {

    public LegendaryCharacter {
        Validation.require(isAgeBetween15And20(age), "Age must be between 15 and 20.");
        Validation.require(isTotalPowerSumOfAllAbilities(strength, agility, perception, totalPower), "Total power must be equal to sum of all ability.");
    }

    private boolean isAgeBetween15And20(int age) {
        return age >= 15 && age <= 20;
    }

    private boolean isTotalPowerSumOfAllAbilities(Strength strength, Agility agility, Perception perception, int totalPower) {
        return totalPower == strength.value() + agility.value() + perception.value();
    }
}
