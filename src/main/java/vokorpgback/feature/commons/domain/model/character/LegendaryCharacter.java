package vokorpgback.feature.commons.domain.model.character;

import vokorpgback.commons.Validation;
import vokorpgback.feature.commons.domain.model.Power;
import vokorpgback.feature.commons.domain.model.knowledge.Knowledge;
import vokorpgback.feature.commons.domain.model.gear.*;

import java.util.List;

// TODO
// penser a faire un package
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
        Validation.require(isSumOfAbilities(fightingMight, strength, agility, perception), "Natural total Might is not equal to abilities sum.");
        Validation.require(isSumOfAbilitiesAndItems(fightingMight, gear), "Total might is not equal to abilities and gear sum.");
    }

    // put static here to not depend of instance state
    private boolean isSumOfAbilities(FightingMight fightingMight, Strength strength, Agility agility, Perception perception) {
        return fightingMight.maxNaturalMight() == strength.value() + agility.value() + perception.value();
    }

    private boolean isSumOfAbilitiesAndItems(FightingMight fightingMight, Gear gear) {
        return fightingMight.maxTotalMight() == fightingMight.maxNaturalMight() + gear.computeMightBonusFromGear();
    }
}
