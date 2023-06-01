package vokorpgback.featureBEFORE.character.domain.model.gear;

import java.util.List;

public abstract class Item {
    protected final String name;
    protected final List<Trait> traits;
    protected final String description;
}
