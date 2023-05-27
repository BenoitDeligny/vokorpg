package vokorpgback.feature.fighting.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
                int characterDamage = characterFighter.rollDamage();
                int numberOfMonstersFaced = characterFighter.getAgility();

                return monsters.stream()
                                .limit(numberOfMonstersFaced)
                                .map(monster -> applyDamageToMonster(monster, characterDamage))
                                .filter(monster -> !monster.isDead() || monsters.contains(monster))
                                .collect(Collectors.toList());
        }

        private MonsterFighter applyDamageToMonster(MonsterFighter monster, int characterDamage) {
                return new MonsterFighter(
                                monster.getMaxFightingPower(),
                                monster.getRemainingFightingPower() - characterDamage,
                                monster.getCombatDice());
        }

        private CharacterFighter computeRemainingCharacterPower(List<MonsterFighter> monsters,
                        CharacterFighter character) {
                int numberOfMonstersFaced = character.getAgility();

                int totalDamage = IntStream.range(0, numberOfMonstersFaced)
                                .mapToObj(monsters::get)
                                .mapToInt(MonsterFighter::rollDamage)
                                .sum();

                if (monsters.size() > 1) {
                        totalDamage += monsters.get(0).rollDamage();
                }

                return new CharacterFighter(
                                character.getMaxFightingPower(),
                                character.getRemainingFightingPower() - totalDamage,
                                character.getAgility(),
                                character.getCombatDice());
        }
}