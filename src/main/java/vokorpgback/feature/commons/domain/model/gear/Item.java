package vokorpgback.feature.commons.domain.model.gear;

import java.util.Optional;

import static vokorpgback.commons.Validation.validateNotNull;

public class Item {
    private final String name;
    private final ItemType type;
    private final Optional<Trait> trait;
    private final String description;
    private final boolean isRelic;

    public Item(String name, ItemType type, Trait trait, String description, boolean isRelic) {
        this.name = validateNotNull(name, "Name should not be null.");
        this.type = type;
        this.trait = Optional.ofNullable(trait);
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
        return trait.orElse(null);
    }

    public String getDescription() {
        return description;
    }

    public boolean isRelic() {
        return isRelic;
    }
}
