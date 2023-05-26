package vokorpgback.feature.fighting.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.fighting.domain.combatchart.MonsterCombatChart;
import vokorpgback.feature.fighting.domain.fighter.MonsterFighter;

class monsterFighterTest {
    @Test
    void FightingMonster_should_haveZeroCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(5, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.ZERO);
        Assertions.assertThat(monsterFighter.computeDamage(null)).isEqualTo(MonsterCombatChart.ZERO.);
    }

    @Test
    void FightingMonster_should_haveOneCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(15, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.ONE);
    }

    @Test
    void FightingMonster_should_haveTwoCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(25, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.TWO);
    }

    @Test
    void FightingMonster_should_haveThreeCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(45, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.THREE);
    }

    @Test
    void FightingMonster_should_haveFourCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(65, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.FOUR);
    }

    @Test
    void FightingMonster_should_haveFiveCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(105, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.FIVE);
    }

    @Test
    void FightingMonster_should_haveSixCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(135, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.SIX);
    }

    @Test
    void FightingMonster_should_haveSevenCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(195, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.SEVEN);
    }

    @Test
    void FightingMonster_should_haveEightCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(255, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.EIGHT);
    }

    @Test
    void FightingMonster_should_haveNineCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(305, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.NINE);
    }

    @Test
    void FightingMonster_should_haveTenCombatDice() {
        // given
        MonsterFighter monsterFighter = new MonsterFighter(555, 5);

        // then
        Assertions.assertThat(monsterFighter.combatDice()).isEqualTo(MonsterCombatChart.TEN);
    }

    @Test
    void FightingMonster_should_beDead() {
        // given
        MonsterFighter character = new MonsterFighter(100, 0);

        // then
        Assertions.assertThat(character.isDead()).isTrue();
    }

    @Test
    void FightingMonster_should_beAlive() {
        // given
        MonsterFighter character = new MonsterFighter(100, 50);

        // then
        Assertions.assertThat(character.isDead()).isFalse();
    }
}