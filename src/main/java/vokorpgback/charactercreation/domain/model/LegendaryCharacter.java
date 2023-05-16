package vokorpgback.charactercreation.domain.model;

import java.util.Random;

public record LegendaryCharacter(
    String name,
    int age,
    Abilities abilities
) {
    public LegendaryCharacter(String name) {
        this(name, rollForAge(), generateAbilities());
    }

    // TODO
    // How to test random assignements
    private static int rollForAge() {
        Random roll = new Random();
        return 11 + (roll.nextInt(6) + 1);
    }

    private static Abilities generateAbilities() {
        return new Abilities(new Ability(), new Ability(), new Ability());
    }
}
