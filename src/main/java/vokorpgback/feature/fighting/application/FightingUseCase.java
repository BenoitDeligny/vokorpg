package vokorpgback.feature.fighting.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import vokorpgback.feature.fighting.domain.FightingCharacter;
import vokorpgback.feature.fighting.domain.FightingMonster;
import vokorpgback.feature.fighting.exposition.dto.FightingCharacterDto;
import vokorpgback.feature.fighting.exposition.dto.FightingMonsterDto;
import vokorpgback.utils.diceroll.DiceRoll;

public class FightingUseCase {

    private final DiceRoll diceRoll;

    public FightingUseCase(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

    // TODO
    // this is not the final return
    // implement the full response
    // add the monster attacks after character's one
    public Optional<List<FightingMonster>> handle(
            FightingCharacterDto fightingCharacterDto,
            List<FightingMonsterDto> monsters,
            int numberOfMonstersFaced) {

        return Optional.of(
                computeRemainingMonsters(
                        toFightingMonsters(monsters),
                        computeFightingCharacterDamages(toFightingCharacter(fightingCharacterDto)),
                        numberOfMonstersFaced));
    }

    private List<FightingMonster> computeRemainingMonsters(
            List<FightingMonster> fightingMonsters,
            int characterDamage,
            int numberOfMonstersFaced) {

        return IntStream.range(0, fightingMonsters.size())
                .mapToObj(
                        i -> applyDamagesToMonster(fightingMonsters.get(i), characterDamage, i, numberOfMonstersFaced))
                .filter(monster -> isAliveOrInOriginalList(monster, fightingMonsters))
                .collect(Collectors.toList());
    }

    private FightingMonster applyDamagesToMonster(
            FightingMonster monster,
            int characterDamage,
            int index,
            int numberOfMonstersFaced) {
        if (index < numberOfMonstersFaced) {
            return applyDamages(monster, characterDamage);
        }
        return monster;
    }
    
    private FightingMonster applyDamages(FightingMonster monster, int characterDamage) {
        return new FightingMonster(
                monster.maxFightingPower(),
                monster.remainingFightingPower() - characterDamage,
                monster.damageDices());
    }

    private boolean isAliveOrInOriginalList(FightingMonster monster, List<FightingMonster> fightingMonsters) {
        return !monster.isDead() || fightingMonsters.contains(monster);
    }

    private List<FightingMonster> toFightingMonsters(List<FightingMonsterDto> dtoList) {
        return dtoList
                .stream()
                .map(this::toFightingMonster)
                .toList();
    }

    private FightingMonster toFightingMonster(FightingMonsterDto dto) {
        return new FightingMonster(dto.getMaxFightingPower(), dto.getRemainingFightingPower(), dto.getDamageDices());
    }

    // TODO
    // add miscellaneous (gear, powers, relic, ...)
    private int computeFightingCharacterDamages(FightingCharacter fightingCharacter) {
        return diceRoll.diceRolls(fightingCharacter.damageDices());
    }

    private FightingCharacter toFightingCharacter(FightingCharacterDto dto) {
        return new FightingCharacter(dto.getMaxFightingPower(), dto.getRemainingFightingPower(), dto.getDamageDices());
    }
}
