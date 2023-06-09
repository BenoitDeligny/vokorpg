package vokorpgback.feature.commons.domain.model.item;

import vokorpgback.feature.character.domain.model.Trait;

import java.util.List;

public class Helmet extends Item {
    public Helmet(String name, List<Trait> traits, String description, boolean isRelic) {
        super(name, traits, description, isRelic);
    }
}
