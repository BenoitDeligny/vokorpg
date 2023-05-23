package vokorpgback.feature.fighting.exposition.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class FightingRequest {

    @NotNull(message = "The fighting character should not be null")
    private FightingCharacterDto fightingCharacter;

    @NotEmpty(message = "The monsters should not be null")
    private List<FightingMonsterDto> monsters;

    public FightingCharacterDto getFightingCharacter() {
        return fightingCharacter;
    }

    public List<FightingMonsterDto> getMonsters() {
        return monsters;
    }
}
