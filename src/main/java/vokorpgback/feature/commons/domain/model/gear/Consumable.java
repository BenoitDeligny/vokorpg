package vokorpgback.feature.commons.domain.model.gear;

import vokorpgback.commons.Validation;

public class Consumable extends Item {
    private final int quantity;

    public Consumable(String name, ItemType type, Trait trait, String description, boolean isRelic, int quantity) {
        super(name, type, trait, description, isRelic);

        Validation.require(isPositiveOrZero(quantity), "Consumable can not have negative quantity.");
        this.quantity = quantity;
    }

    private boolean isPositiveOrZero(int consumableQuantity) {
        return consumableQuantity >= 0;
    }

    public int getQuantity() {
        return quantity;
    }
}
