package vokorpgback.feature.fighting.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.CharacterCombatDice;


public class FightingCharacterTest {

    @Test
    void fightingCharacter_should_haveZeroCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(5, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.ZERO);
    }

    @Test
    void fightingCharacter_should_haveOneCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(15, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.ONE);
    }

    @Test
    void fightingCharacter_should_haveTwoCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(25, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.TWO);
    }

    @Test
    void fightingCharacter_should_haveThreeCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(45, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.THREE);
    }

    @Test
    void fightingCharacter_should_haveFourCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(65, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.FOUR);
    }

    @Test
    void fightingCharacter_should_haveFiveCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(105, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.FIVE);
    }

    @Test
    void fightingCharacter_should_haveSixCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(135, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.SIX);
    }

    @Test
    void fightingCharacter_should_haveSevenCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(165, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.SEVEN);
    }

    @Test
    void fightingCharacter_should_haveEightCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(215, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.EIGHT);
    }

    @Test
    void fightingCharacter_should_haveNineCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(255, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.NINE);
    }

    @Test
    void fightingCharacter_should_haveTenCombatDice() {
        // given
        FightingCharacter fightingCharacter = new FightingCharacter(555, 5, 3);

        // then
        Assertions.assertThat(fightingCharacter.combatDice()).isEqualTo(CharacterCombatDice.TEN);
    }

    @Test
    void fightingCharacter_should_beDead() {
        // given
        FightingCharacter character = new FightingCharacter(100, 0, 3);

        // then
        Assertions.assertThat(character.isDead()).isTrue();
    }

    @Test
    void fightingCharacter_should_beAlive() {
        // given
        FightingCharacter character = new FightingCharacter(100, 5, 30);

        // then
        Assertions.assertThat(character.isDead()).isFalse();
    }

}
