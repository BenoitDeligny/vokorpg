package vokorpgback.feature.commons.domain.model;

import vokorpgback.feature.fighting.domain.FightingCharacter;
import vokorpgback.feature.fighting.domain.FightingMonster;

import java.util.List;

public record Fight(
        FightingCharacter character,
        List<FightingMonster> monsters
) {

}
