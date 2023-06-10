package vokorpgback.feature.commons.domain.model.gear;

public class Item {
    private final String name;
    private final ItemType type;
    private final Trait trait;
    private final String description;
    private final boolean isRelic;

    protected Item(String name, ItemType type, Trait trait, String description, boolean isRelic) {
        // TODO
        // add isNotNull validation
        this.name = name;
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
