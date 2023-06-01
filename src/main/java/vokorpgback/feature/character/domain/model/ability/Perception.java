package vokorpgback.feature.character.domain.model.ability;

import vokorpgback.commons.Validation;

public record Perception(int value) implements Ability {
    public Perception {
        Validation.require(isPositive(), "Perception should be positive.");
    }

    @Override
    public boolean isPositive() {
        return value > 0;
    }

}
