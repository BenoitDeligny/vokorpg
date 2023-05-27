package vokorpgback.feature.fighting.domain;

import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

import java.util.List;

public record CombatResult(
        CharacterFighter characterFighter,
        List<MonsterFighter> monsterFighters) {

}
