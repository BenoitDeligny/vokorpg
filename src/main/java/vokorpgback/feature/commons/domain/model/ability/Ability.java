package vokorpgback.feature.commons.domain.model.ability;

import vokorpgback.commons.Validation;

public abstract class Ability {

    private final int value;

    protected Ability(int value) {
        Validation.require(isPositive(value), "An Ability should be positive.");
        this.value = value;
    }

    private boolean isPositive(int value) {
        return value > 0;
    }

    public int value() {
        return value;
    }
}
