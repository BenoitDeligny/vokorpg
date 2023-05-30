package vokorpgback.feature.fighting.domain;

import java.util.List;
import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

public record Fight(
    CharacterFighter character, List<MonsterFighter> monsters, boolean attemptToFlee) {}
