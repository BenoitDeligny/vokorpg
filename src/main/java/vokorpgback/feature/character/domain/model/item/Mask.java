package vokorpgback.feature.character.domain.model.item;

import vokorpgback.feature.character.domain.model.Trait;

import java.util.List;

public class Mask extends Item {
    protected Mask(String name, List<Trait> traits, String description, boolean isRelic) {
        super(name, traits, description, isRelic);
    }
}
