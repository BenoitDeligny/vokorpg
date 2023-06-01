package vokorpgback.feature.character.domain.model.ability;

import vokorpgback.commons.Validation;

public record Agility(int value) implements Ability {
    public Agility {
        Validation.require(isPositive(), "Agility should be positive.");
    }

    @Override
    public boolean isPositive() {
        return value > 0;
    }
}
