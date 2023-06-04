package vokorpgback.feature.character.domain.model.gear;

import java.util.List;

public abstract class Item {
    protected final String name;
    protected final List<Trait> traits;
    protected final String description;

    protected Item(String name, List<Trait> traits, String description) {
        this.name = name;
        this.traits = traits;
        this.description = description;
    }
}
