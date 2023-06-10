package vokorpgback.feature.commons.domain.model.character.ability;

import vokorpgback.commons.Validation;

public record Strength(int value) {
    public Strength {
        Validation.require(isPositive(value), "Strength should be positive.");
    }

    public boolean isPositive(int value) {
        return value > 0;
    }
}
