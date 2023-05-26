package vokorpgback.feature.fighting.application;

import java.util.List;
import java.util.stream.Collectors;

import vokorpgback.feature.fighting.domain.Fight;
import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

public class FightingUseCase {
    public CombatResult handle(Fight fight) {
        CharacterFighter characterFighter = fight.character();
        List<MonsterFighter> monsters = fight.monsters();

        List<MonsterFighter> remainingMonsters = computeRemainingMonsters(monsters, characterFighter);
        CharacterFighter remainingCharacterPower = computeRemainingCharacterPower(remainingMonsters,
                characterFighter);

        return new CombatResult(remainingCharacterPower, remainingMonsters);
    }

    private List<MonsterFighter> computeRemainingMonsters(List<MonsterFighter> monsters,
                                                          CharacterFighter characterFighter) {
        int characterDamage = characterFighter.combatDice().computeDamage();
        int numberOfMonstersFaced = characterFighter.agility();

        return monsters.stream()
                .limit(numberOfMonstersFaced)
                .map(monster -> applyDamageToMonster(monster, characterDamage))
                .filter(monster -> !monster.isDead() || monsters.contains(monster))
                .collect(Collectors.toList());
    }

    private MonsterFighter applyDamageToMonster(MonsterFighter monster, int characterDamage) {
        return new MonsterFighter(
                monster.maxFightingPower(),
                monster.remainingFightingPower() - characterDamage,
                monster.combatDice());
    }

    private CharacterFighter computeRemainingCharacterPower(List<MonsterFighter> monsters, CharacterFighter characterFighter) {
        int numberOfMonstersFaced = characterFighter.agility();
        
        int totalDamage = monsters.stream()
                .limit(numberOfMonstersFaced)
                .mapToInt(monster -> monster.combatDice().computeDamage())
                .sum();

        return new CharacterFighter(
                characterFighter.maxFightingPower(),
                characterFighter.remainingFightingPower() - totalDamage,
                characterFighter.agility()
        );
    }
}