package vokorpgback.feature.commons.domain.model.character;

import vokorpgback.commons.Validation;

public record Agility(int value) {
    public Agility {
        Validation.require(isPositive(value), "Agility should be positive.");
    }

    public boolean isPositive(int value) {
        return value > 0;
    }
}
