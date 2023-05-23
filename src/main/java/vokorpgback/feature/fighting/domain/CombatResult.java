package vokorpgback.feature.fighting.domain;

import java.util.List;

public record CombatResult(
    FightingCharacter fightingCharacter,
    List<FightingMonster> fightingMonsters
) {
    
}
