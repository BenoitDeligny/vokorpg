package vokorpgback.feature.commons.domain.model.character.gear;

import vokorpgback.commons.Validation;

import java.util.Objects;

public class Consumable extends Item {
    private final int quantity;

    public Consumable(String name, ItemType type, Trait trait, String description, boolean isRelic, int quantity) {
        super(name, type, trait, description, isRelic);

        Validation.require(isConsumableType(type), "Consumable should be of consumable type.");
        Validation.require(isPositiveOrZero(quantity), "Consumable can not have negative quantity.");
        this.quantity = quantity;
    }

    private boolean isConsumableType(ItemType itemType) {
        return itemType == ItemType.CONSUMABLE;
    }
    private boolean isPositiveOrZero(int consumableQuantity) {
        return consumableQuantity >= 0;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumable that = (Consumable) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    @Override
    public String toString() {
        return "Consumable{" +
                "quantity=" + quantity +
                '}';
    }
}
