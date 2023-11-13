package vokorpgback.feature.commons.domain.model.gear;

import java.util.Optional;

import static vokorpgback.commons.Validation.validateNotNull;

public class Item {
    private final String name;
    private final ItemType type;
    private final Trait trait;
    private final String description;
    private final boolean isRelic;

    public Item(String name, ItemType type, Trait trait, String description, boolean isRelic) {
        this.name = validateNotNull(name, "Name should not be null.");
        this.type = type;
        this.trait = trait;
        this.description = description;
        this.isRelic = isRelic;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public Trait getTrait() {
        return trait;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRelic() {
        return isRelic;
    }
}
