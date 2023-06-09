package vokorpgback.feature.commons.domain.model.ability;

import vokorpgback.commons.Validation;

public record Strength(int value) {
    public Strength {
        Validation.require(!isValid(), "Strength should be positive.");
    }

    public boolean isValid() {
        return value > 0;
    }
}
