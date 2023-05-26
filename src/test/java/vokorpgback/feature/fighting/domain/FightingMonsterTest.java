package vokorpgback.feature.fighting.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.MonsterCombatDice;

import static org.junit.jupiter.api.Assertions.*;

class FightingMonsterTest {
    @Test
    void FightingMonster_should_haveZeroCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(5, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.ZERO);
        Assertions.assertThat(FightingMonster.computeDamage(null)).isEqualTo(MonsterCombatDice.ZERO.);
    }

    @Test
    void FightingMonster_should_haveOneCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(15, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.ONE);
    }

    @Test
    void FightingMonster_should_haveTwoCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(25, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.TWO);
    }

    @Test
    void FightingMonster_should_haveThreeCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(45, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.THREE);
    }

    @Test
    void FightingMonster_should_haveFourCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(65, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.FOUR);
    }

    @Test
    void FightingMonster_should_haveFiveCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(105, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.FIVE);
    }

    @Test
    void FightingMonster_should_haveSixCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(135, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.SIX);
    }

    @Test
    void FightingMonster_should_haveSevenCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(195, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.SEVEN);
    }

    @Test
    void FightingMonster_should_haveEightCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(255, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.EIGHT);
    }

    @Test
    void FightingMonster_should_haveNineCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(305, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.NINE);
    }

    @Test
    void FightingMonster_should_haveTenCombatDice() {
        // given
        FightingMonster FightingMonster = new FightingMonster(555, 5);

        // then
        Assertions.assertThat(FightingMonster.combatDice()).isEqualTo(MonsterCombatDice.TEN);
    }

    @Test
    void FightingMonster_should_beDead() {
        // given
        FightingMonster character = new FightingMonster(100, 0);

        // then
        Assertions.assertThat(character.isDead()).isTrue();
    }

    @Test
    void FightingMonster_should_beAlive() {
        // given
        FightingMonster character = new FightingMonster(100, 50);

        // then
        Assertions.assertThat(character.isDead()).isFalse();
    }
}