package vokorpgback.feature.fighting.exposition.dto;

import java.util.List;

public class FightingResponse {
    private final FightingCharacterDto character;
    private final List<FightingMonsterDto> monsters;

    public FightingResponse(FightingCharacterDto character, List<FightingMonsterDto> monsters) {
        this.character = character;
        this.monsters = monsters;
    }

    public FightingCharacterDto getCharacter() {
        return character;
    }

    public List<FightingMonsterDto> getMonsters() {
        return monsters;
    }
}
