package vokorpgback.feature.fighting.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.fighting.domain.combatchart.CharacterCombatChart;
import vokorpgback.feature.fighting.domain.fighter.CharacterFighter;


public class characterFighterTest {

    @Test
    void fightingCharacter_should_haveZeroCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(5, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.ZERO);
    }

    @Test
    void fightingCharacter_should_haveOneCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(15, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.ONE);
    }

    @Test
    void fightingCharacter_should_haveTwoCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(25, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.TWO);
    }

    @Test
    void fightingCharacter_should_haveThreeCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(45, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.THREE);
    }

    @Test
    void fightingCharacter_should_haveFourCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(65, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.FOUR);
    }

    @Test
    void fightingCharacter_should_haveFiveCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(105, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.FIVE);
    }

    @Test
    void fightingCharacter_should_haveSixCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(135, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.SIX);
    }

    @Test
    void fightingCharacter_should_haveSevenCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(165, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.SEVEN);
    }

    @Test
    void fightingCharacter_should_haveEightCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(215, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.EIGHT);
    }

    @Test
    void fightingCharacter_should_haveNineCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(255, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.NINE);
    }

    @Test
    void fightingCharacter_should_haveTenCombatDice() {
        // given
        CharacterFighter characterFighter = new CharacterFighter(555, 5, 3);

        // then
        Assertions.assertThat(characterFighter.combatDice()).isEqualTo(CharacterCombatChart.TEN);
    }

    @Test
    void fightingCharacter_should_beDead() {
        // given
        CharacterFighter character = new CharacterFighter(100, 0, 3);

        // then
        Assertions.assertThat(character.isDead()).isTrue();
    }

    @Test
    void fightingCharacter_should_beAlive() {
        // given
        CharacterFighter character = new CharacterFighter(100, 5, 30);

        // then
        Assertions.assertThat(character.isDead()).isFalse();
    }

}
