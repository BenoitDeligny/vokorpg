package vokorpgback.feature.commons.domain.model.character;

import vokorpgback.commons.Validation;

public record Perception(int value) {

    public Perception {
        Validation.require(isPositive(value), "Perception should be positive.");
    }

    public boolean isPositive(int value) {
        return value > 0;
    }

}
