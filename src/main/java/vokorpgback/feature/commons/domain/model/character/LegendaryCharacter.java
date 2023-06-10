package vokorpgback.feature.commons.domain.model.character;

import vokorpgback.feature.commons.domain.model.Power;
import vokorpgback.feature.commons.domain.model.knowledge.Knowledge;
import vokorpgback.feature.commons.domain.model.character.ability.Agility;
import vokorpgback.feature.commons.domain.model.character.ability.Perception;
import vokorpgback.feature.commons.domain.model.character.ability.Strength;
import vokorpgback.feature.commons.domain.model.gear.*;

import java.util.List;

public record LegendaryCharacter(
        Identity identity,
        Strength strength,
        Agility agility,
        Perception perception,
        Gear gear,
        List<Power> powers,
        List<Knowledge> knowledge,
        FightingMight fightingMight,
        BackPack backPack
) {

    public LegendaryCharacter {
        // TODO validate powers = sums
    }
}
