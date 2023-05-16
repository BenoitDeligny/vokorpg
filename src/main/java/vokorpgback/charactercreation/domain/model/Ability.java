package vokorpgback.charactercreation.domain.model;

import java.util.Random;

public record Ability(
    int value
) {

    public Ability() {
        this(rollForCharacterAbility());
    }

    private static int rollForCharacterAbility() {
        Random roll = new Random();
        return 1 + (roll.nextInt(6) + 1);
    }
}
