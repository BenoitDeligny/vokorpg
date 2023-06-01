package vokorpgback.featureBEFORE.fighting.domain;

import vokorpgback.featureBEFORE.fighting.domain.fighter.CharacterFighter;
import vokorpgback.featureBEFORE.fighting.domain.fighter.MonsterFighter;

import java.util.List;

public record CombatResult(
        CharacterFighter characterFighter,
        List<MonsterFighter> monsterFighters,
        FightStatus fightStatus) {
}
