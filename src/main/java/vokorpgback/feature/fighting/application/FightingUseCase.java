package vokorpgback.feature.fighting.application;

import java.util.List;
import java.util.stream.Collectors;

import vokorpgback.feature.commons.domain.model.Fight;
import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.domain.FightingCharacter;
import vokorpgback.feature.fighting.domain.FightingMonster;

public class FightingUseCase {
    public CombatResult handle(Fight fight) {
        FightingCharacter fightingCharacter = fight.character();
        List<FightingMonster> monsters = fight.monsters();

        List<FightingMonster> remainingMonsters = computeRemainingMonsters(monsters, fightingCharacter);
        FightingCharacter remainingCharacterPower = computeRemainingCharacterPower(remainingMonsters,
                fightingCharacter);

        return new CombatResult(remainingCharacterPower, remainingMonsters);
    }

    private List<FightingMonster> computeRemainingMonsters(List<FightingMonster> monsters,
            FightingCharacter fightingCharacter) {
        int characterDamage = fightingCharacter.combatDice().computeDamage();
        int numberOfMonstersFaced = fightingCharacter.agility();

        return monsters.stream()
                .limit(numberOfMonstersFaced)
                .map(monster -> applyDamageToMonster(monster, characterDamage))
                .filter(monster -> !monster.isDead() || monsters.contains(monster))
                .collect(Collectors.toList());
    }

    private FightingMonster applyDamageToMonster(FightingMonster monster, int characterDamage) {
        return new FightingMonster(
                monster.maxFightingPower(),
                monster.remainingFightingPower() - characterDamage,
                monster.combatDice());
    }

    private FightingCharacter computeRemainingCharacterPower(List<FightingMonster> monsters, FightingCharacter fightingCharacter) {
        int numberOfMonstersFaced = fightingCharacter.agility();
        
        int totalDamage = monsters.stream()
                .limit(numberOfMonstersFaced)
                .mapToInt(monster -> monster.combatDice().computeDamage())
                .sum();

        return new FightingCharacter(
                fightingCharacter.maxFightingPower(),
                fightingCharacter.remainingFightingPower() - totalDamage,
                fightingCharacter.agility()
        );
    }
}