package vokorpgback.feature.character.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vokorpgback.commons.LoadedDice;
import vokorpgback.feature.character.domain.model.Ability;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

class AbilitiesTest {
    
    @Test
    void generateAbilities_when_normalMode() {
        // given
        GameMode gameMode = GameMode.NORMAL;
        Dice strengthDice = new LoadedDice(1); // return 3
        Dice agilityDice = new LoadedDice(2); // return 4
        Dice perceptionDice = new LoadedDice(3); // return 2

        // when
        Ability expectedStrength = Ability.generateAbility(gameMode, strengthDice);
        Ability expectedAgility = Ability.generateAbility(gameMode, agilityDice);
        Ability expectedPerception = Ability.generateAbility(gameMode, perceptionDice);

        // then
        Assertions.assertThat(expectedStrength.value()).isEqualTo(4);
        Assertions.assertThat(expectedAgility.value()).isEqualTo(5);
        Assertions.assertThat(expectedPerception.value()).isEqualTo(3);
    }

    @Test
    void generateAbilities_when_easyMode() {
        // given
        GameMode gameMode = GameMode.EASY;
        Dice strengthDice = new LoadedDice(1); // return 3
        Dice agilityDice = new LoadedDice(2); // return 4
        Dice perceptionDice = new LoadedDice(3); // return 2

        // when
        Ability expectedStrength = Ability.generateAbility(gameMode, strengthDice);
        Ability expectedAgility = Ability.generateAbility(gameMode, agilityDice);
        Ability expectedPerception = Ability.generateAbility(gameMode, perceptionDice);

        // then
        Assertions.assertThat(expectedStrength.value()).isEqualTo(7);
        Assertions.assertThat(expectedAgility.value()).isEqualTo(8);
        Assertions.assertThat(expectedPerception.value()).isEqualTo(6);
    }
}
