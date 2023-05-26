package vokorpgback.feature.fighting.domain;

import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

import java.util.List;

public record Fight(
        CharacterFighter character,
        List<MonsterFighter> monsters
) {

}
