package vokorpgback.feature.fighting.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import vokorpgback.feature.fighting.domain.CombatResult;
import vokorpgback.feature.fighting.domain.Fight;
import vokorpgback.feature.fighting.domain.FightStatus;
import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;
import vokorpgback.feature.fighting.domain.fighter.Fighter;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

public class FightingUseCase {

  public CombatResult handle(Fight fight) {
    CharacterFighter characterFighter = fight.character();
    List<MonsterFighter> monsters = fight.monsters();

    if (fight.attemptToFlee()) {
      if ((computeCharacterFleeingScore(characterFighter) > computeFightingMonsterTotalPower(monsters))) {
        return new CombatResult(characterFighter, monsters, FightStatus.FLED);
      }
    }

    List<MonsterFighter> remainingMonsters = computeRemainingMonsters(monsters, characterFighter);

    CharacterFighter remainingCharacterPower =
        computeRemainingCharacterPower(remainingMonsters, characterFighter);

    FightStatus fightStatus = computeFightStatus(remainingMonsters, remainingCharacterPower);

    return new CombatResult(remainingCharacterPower, remainingMonsters, fightStatus);
  }

  private int computeFightingMonsterTotalPower(List<MonsterFighter> monsters) {

    return IntStream.range(0, monsters.size())
    .mapToObj(monsters::get)
    .mapToInt(Fighter::getRemainingFightingPower)
    .sum();
  }

  private int computeCharacterFleeingScore(CharacterFighter character) {
    return character.getCombatDice().roll() +
    character.getCombatDice().roll() +
    character.getAgility();
  }

  private List<MonsterFighter> computeRemainingMonsters(
      List<MonsterFighter> monsters, CharacterFighter characterFighter) {
    int characterDamage = characterFighter.rollDamage();

    return IntStream.range(0, monsters.size())
        .mapToObj(
            i -> applyDamagesToMonsters(monsters.get(i), characterDamage, i, characterFighter.getAgility()))
        .filter(monster -> isAlive(monster, monsters))
        .collect(Collectors.toList());
  }

  private MonsterFighter applyDamagesToMonsters(
      MonsterFighter monster, int characterDamage, int index, int numberOfMonstersFaced) {
    if (index < numberOfMonstersFaced) {
      return applyDamageToMonster(monster, characterDamage);
    }
    return monster;
  }

  private MonsterFighter applyDamageToMonster(MonsterFighter monster, int characterDamage) {
    return new MonsterFighter(
        monster.getMaxFightingPower(),
        computeRemainingFightingPower(monster.getRemainingFightingPower(), characterDamage),
        monster.getCombatDice());
  }

  private boolean isAlive(MonsterFighter monster, List<MonsterFighter> fightingMonsters) {
    return !monster.isDead() || fightingMonsters.contains(monster);
  }

  private CharacterFighter computeRemainingCharacterPower(
      List<MonsterFighter> monsters, CharacterFighter character) {

    int totalDamage =
        monsters.stream().limit(character.getAgility()).mapToInt(MonsterFighter::rollDamage).sum();

    if (monsters.size() > 1) {
      totalDamage += monsters.get(0).rollDamage();
    }

    return new CharacterFighter(
        character.getMaxFightingPower(),
        computeRemainingFightingPower(character.getRemainingFightingPower(), totalDamage),
        character.getAgility(),
        character.getCombatDice());
  }

  private int computeRemainingFightingPower(int actualFightingPower, int damageTaken) {
    return Math.max(actualFightingPower - damageTaken, 0);
  }

  private FightStatus computeFightStatus(
      List<MonsterFighter> remainingMonsters, CharacterFighter character) {
    if (remainingMonsters.isEmpty()) {
      return FightStatus.WON;
    }

    if (character.getRemainingFightingPower() == 0) {
      return FightStatus.LOST;
    }

    return FightStatus.ONGOING;
  }
}
