package vokorpgback.feature.commons.domain.model.item;

import vokorpgback.feature.character.domain.model.Trait;

import java.util.List;

public class Item {
    protected final String name;
    protected final List<Trait> traits;
    protected final String description;
    private final boolean isRelic;

    protected Item(String name, List<Trait> traits, String description, boolean isRelic) {
        this.name = name;
        this.traits = traits;
        this.description = description;
        this.isRelic = isRelic;
    }

    public String getName() {
        return name;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRelic() {
        return isRelic;
    }
}
