package vokorpgback.feature.character.domain.model.ability;

import vokorpgback.commons.Validation;

public record Strength(int value) implements Ability {
    public Strength {
        Validation.require(isPositive(), "Strength should be positive.");
    }

    @Override
    public boolean isPositive() {
        return value > 0;
    }
}
