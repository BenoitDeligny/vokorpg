package vokorpgback.feature.fighting.domain;

import java.util.List;
import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

public record CombatResult(
    CharacterFighter characterFighter,
    List<MonsterFighter> monsterFighters,
    FightStatus fightStatus) {}
