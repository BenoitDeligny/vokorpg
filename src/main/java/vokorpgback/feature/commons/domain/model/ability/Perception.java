package vokorpgback.feature.commons.domain.model.ability;

import vokorpgback.commons.Validation;

public record Perception(int value) {
    public Perception {
        Validation.require(!isValid(), "Perception should be positive.");
    }

    public boolean isValid() {
        return value > 0;
    }

}
