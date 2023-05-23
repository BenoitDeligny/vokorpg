package vokorpgback.feature.fighting.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import vokorpgback.feature.fighting.domain.CombatResult;
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
    // refacto this class
    public Optional<CombatResult> handle(
            FightingCharacterDto fightingCharacterDto,
            List<FightingMonsterDto> monsters,
            int numberOfMonstersFaced) {

        Optional<List<FightingMonster>> remainingMonsters = Optional.of(
                ComputeCharacterAttack(
                        toFightingMonsters(monsters),
                        computeFightingCharacterDamages(toFightingCharacter(fightingCharacterDto)),
                        numberOfMonstersFaced));

        Optional<FightingCharacter> remainingCharacterPower = Optional.of(
                // check if monsters is empty
                computeMonstersAttack(remainingMonsters.get(), toFightingCharacter(fightingCharacterDto), numberOfMonstersFaced)
        );

        return Optional.of(new CombatResult(remainingCharacterPower.get(), remainingMonsters.get()));
    }

    private FightingCharacter computeMonstersAttack(List<FightingMonster> fightingMonsters, FightingCharacter fightingCharacter, int numberOfMonstersFaced) {
        List<FightingMonster> facedMonsters;

        if (fightingMonsters.size() < numberOfMonstersFaced) {
            facedMonsters = fightingMonsters.subList(0, fightingMonsters.size());
        } else {
            facedMonsters = fightingMonsters.subList(0, numberOfMonstersFaced);
        }
        return applyDamagesToCharacter(facedMonsters, fightingCharacter);
    }

    private FightingCharacter applyDamagesToCharacter(List<FightingMonster> facedMonsters, FightingCharacter fightingCharacter) {
        // don't forget the +1 dice
        // if little monster damageDice could be 1 damage only
        int totalDamagesDice = facedMonsters.stream().map(FightingMonster::damageDice).mapToInt(Integer::intValue).sum();

        int totalDamages = 0;

        if (facedMonsters.size() > 1) {
            totalDamages = diceRoll.diceRolls(totalDamagesDice + 1);
        } else {
            totalDamages = diceRoll.diceRolls(totalDamagesDice);
        }

        return new FightingCharacter(
                fightingCharacter.maxFightingPower(),
                fightingCharacter.remainingFightingPower() - totalDamages,
                fightingCharacter.damageDices());
    }

    private List<FightingMonster> ComputeCharacterAttack(
            List<FightingMonster> fightingMonsters,
            int characterDamage,
            int numberOfMonstersFaced) {

        return IntStream.range(0, fightingMonsters.size())
                .mapToObj(
                        i -> applyDamagesToMonsters(fightingMonsters.get(i), characterDamage, i, numberOfMonstersFaced))
                .filter(monster -> isAlive(monster, fightingMonsters))
                .collect(Collectors.toList());
    }

    private FightingMonster applyDamagesToMonsters(
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
                monster.damageDice());
    }

    private boolean isAlive(FightingMonster monster, List<FightingMonster> fightingMonsters) {
        return !monster.isDead() || fightingMonsters.contains(monster);
    }

    private List<FightingMonster> toFightingMonsters(List<FightingMonsterDto> dtoList) {
        return dtoList
                .stream()
                .map(this::toFightingMonster)
                .toList();
    }

    private FightingMonster toFightingMonster(FightingMonsterDto dto) {
        return new FightingMonster(dto.getMaxFightingPower(), dto.getRemainingFightingPower(), dto.getDamageDice());
    }

    // TODO
    // add miscellaneous (gear, powers, relic, ...)
    private int computeFightingCharacterDamages(FightingCharacter fightingCharacter) {
        return diceRoll.diceRolls(fightingCharacter.damageDices());
    }

    private FightingCharacter toFightingCharacter(FightingCharacterDto dto) {
        return new FightingCharacter(dto.getMaxFightingPower(), dto.getRemainingFightingPower(), dto.getDamageDice());
    }
}
