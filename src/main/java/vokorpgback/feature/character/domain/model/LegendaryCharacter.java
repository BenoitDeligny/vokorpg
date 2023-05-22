package vokorpgback.feature.character.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public record LegendaryCharacter(
        String name,
        int age,
        Abilities abilities,
        int totalPower) {

    public int computeFightingPower(Ability ability, int weaponBonus, int shieldBonus, List<Integer> miscellaneousBonus) {
        return ability.value() +
                weaponBonus +
                shieldBonus +
                miscellaneousBonus
                        .stream()
                        .collect(Collectors.summingInt(Integer::intValue));
    }
}
