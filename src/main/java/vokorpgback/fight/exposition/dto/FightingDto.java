package vokorpgback.fight.exposition.dto;

import java.util.List;

public class FightingDto {
    private FightingCharacterDto fightingCharacter;
    private List<FightingMonsterDto> monsters;
    private int numberOfMonstersFaced;

    public FightingCharacterDto getFightingCharacter() {
        return fightingCharacter;
    }

    public List<FightingMonsterDto> getMonsters() {
        return monsters;
    }

    public int getNumberOfMonstersFaced() {
        return numberOfMonstersFaced;
    }

}
