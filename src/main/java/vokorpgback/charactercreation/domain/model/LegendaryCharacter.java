package vokorpgback.charactercreation.domain.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public record LegendaryCharacter(
    String name,
    int age,
    Abilities abilities
) {
    public LegendaryCharacter(String name) {
        this(name, rollForAge(), generateAbilities());
    }

    public int fightingPower(Ability ability, int weaponBonus, int shieldBonus, List<Integer> miscellaneousBonus) {
        return ability.value() + weaponBonus + shieldBonus + miscellaneousBonus.stream().collect(Collectors.summingInt(Integer::intValue));
    }
    
    private static int rollForAge() {
        Random roll = new Random();
        return 11 + (roll.nextInt(6) + 1);
    }

    private static Abilities generateAbilities() {
        return new Abilities(new Ability(), new Ability(), new Ability());
    }

}
