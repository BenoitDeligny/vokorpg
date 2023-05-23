package vokorpgback.feature.character.domain.model;

import vokorpgback.Validation;

import java.util.List;
import java.util.stream.Collectors;

public record LegendaryCharacter(
        String name,
        int age,
        Abilities abilities,
        int totalPower) {

    public LegendaryCharacter {
        Validation.require(age < 14, "Age must be");
        Validation.require(age > 21, "Age must be");
    }

    public int computeFightingPower(Ability ability, int weaponBonus, int shieldBonus, List<Integer> miscellaneousBonus) {
        return ability.value() +
                weaponBonus +
                shieldBonus +
                miscellaneousBonus
                        .stream().mapToInt(Integer::intValue).sum();
    }
}
