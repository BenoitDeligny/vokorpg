package vokorpgback.feature.fighting.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import vokorpgback.feature.commons.domain.model.Fight;
import vokorpgback.feature.commons.domain.model.GameDice;
import vokorpgback.feature.commons.domain.port.Dice;
import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.domain.FightingCharacter;
import vokorpgback.feature.fighting.domain.FightingMonster;
import vokorpgback.feature.fighting.exposition.dto.FightingCharacterDto;
import vokorpgback.feature.fighting.exposition.dto.FightingMonsterDto;

public class FightingUseCase {


    public FightingUseCase() {
    }

    public CombatResult handle(Fight fight) {
        FightingCharacter fightingCharacter = fight.character();
        List<FightingMonster> monsters = fight.monsters();
        int numberOfMonstersFaced = fight.character().agility();

        List<FightingMonster> remainingMonsters = ComputeCharacterAttack(
                monsters,
                computeFightingCharacterDamages(fightingCharacter),
                numberOfMonstersFaced);

        FightingCharacter remainingCharacterPower = computeMonstersAttack(remainingMonsters, fightingCharacter, numberOfMonstersFaced);

        return new CombatResult(remainingCharacterPower, remainingMonsters);
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
        Dice dice = new GameDice(6);
        // if little monster combatDice could be 1 damage only
        int totalCombatDice = facedMonsters.stream().map(FightingMonster::combatDice).mapToInt(Integer::intValue).sum();

        int totalDamages = 0;

        if (facedMonsters.size() > 1) {
            for (int i = 0; i < totalCombatDice; i++) {
                totalDamages += dice.roll();
            }
        } else {
            totalDamages += dice.roll();
            ;
        }

        return new FightingCharacter(
                fightingCharacter.maxFightingPower(),
                fightingCharacter.remainingFightingPower() - totalDamages,
                fightingCharacter.agility());
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
                monster.combatDice());
    }

    private boolean isAlive(FightingMonster monster, List<FightingMonster> fightingMonsters) {
        return !monster.isDead() || fightingMonsters.contains(monster);
    }

    // TODO
    // add miscellaneous (gear, powers, relic, ...)
    private int computeFightingCharacterDamages(FightingCharacter fightingCharacter) {
        Dice dice = new GameDice(6);
        int totalDamages = 0;
        for (int i = 0; i < fightingCharacter.combatDice().getNumberOfDice(); i++) {
            totalDamages += dice.roll();
        }
        ;

        return totalDamages;
    }
}
