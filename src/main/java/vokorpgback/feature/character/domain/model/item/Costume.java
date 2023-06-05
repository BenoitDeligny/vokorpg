package vokorpgback.feature.character.domain.model.item;

import vokorpgback.feature.character.domain.model.Trait;

import java.util.List;

public class Costume extends Item {
    protected Costume(String name, List<Trait> traits, String description, boolean isRelic) {
        super(name, traits, description, isRelic);
    }
}
