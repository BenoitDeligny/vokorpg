package vokorpgback.feature.commons.domain.model.item;

import vokorpgback.feature.character.domain.model.Trait;

import java.util.List;

public class Gloves extends Item {
    public Gloves(String name, List<Trait> traits, String description, boolean isRelic) {
        super(name, traits, description, isRelic);
    }
}
