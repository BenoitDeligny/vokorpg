package vokorpgback.feature.commons.domain.model.ability;

import vokorpgback.commons.Validation;

public record Agility(int value) {
    public Agility {
        Validation.require(!isValid(), "Agility should be positive.");
    }

    public boolean isValid() {
        return value > 0;
    }
}
