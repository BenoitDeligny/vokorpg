package vokorpgback.feature.commons.domain.model;

import vokorpgback.feature.commons.domain.model.ability.Agility;
import vokorpgback.feature.commons.domain.model.ability.Perception;
import vokorpgback.feature.commons.domain.model.ability.Strength;
import vokorpgback.feature.commons.domain.model.item.*;

public record LegendaryCharacter(
        Identity identity,
        Strength strength,
        Agility agility,
        Perception perception,
        Gear gear,
        Power power
) {

    public LegendaryCharacter {
        // TODO validate powers = sums
    }
}
