package vokorpgback.feature.fighting.exposition.dto;

import java.util.List;

public record FightingResponse(
    FightingCharacterDto character, List<FightingMonsterDto> monsters, String fightStatus) {}
