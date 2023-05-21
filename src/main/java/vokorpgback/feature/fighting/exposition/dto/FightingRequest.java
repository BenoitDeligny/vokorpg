package vokorpgback.feature.fighting.exposition.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class FightingRequest {

    @NotNull(message = "The fighting character should not be null")
    private FightingCharacterDto fightingCharacter;

    @NotEmpty(message = "The monsters should not be null")
    private List<FightingMonsterDto> monsters;

    @Positive(message = "Number of monsters faced should be positive")
    private int numberOfMonstersFaced;

    public FightingCharacterDto getFightingCharacter() {
        return fightingCharacter;
    }

    public List<FightingMonsterDto> getMonsters() {
        return monsters;
    }

    public int getNumberOfMonstersFaced() {
        if (numberOfMonstersFaced > fightingCharacter.getAgility()) {
            // TODO
            // add specific exception
            throw new RuntimeException("You can't fight more monsters than your agility score at the same time.");
        }
        return numberOfMonstersFaced;
    }

}
