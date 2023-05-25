package vokorpgback.feature.character.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vokorpgback.commons.LoadedDice;
import vokorpgback.feature.character.domain.model.Abilities;
import vokorpgback.feature.character.domain.model.Ability;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

class AbilitiesTest {

    @Test
    void generateAbilities_when_normalMode() {
        // given
        GameMode gameMode = GameMode.NORMAL;

        Abilities expectedAbilities = new Abilities(
                new Ability(4),
                new Ability(5),
                new Ability(3)
        );

        // when
        Dice strengthDice = new LoadedDice(3); // return 3
        Dice agilityDice = new LoadedDice(4); // return 4
        Dice perceptionDice = new LoadedDice(2); // return 2

        Abilities underTestAbilities = new Abilities(
                Ability.generateAbility(strengthDice, gameMode),
                Ability.generateAbility(agilityDice, gameMode),
                Ability.generateAbility(perceptionDice, gameMode)
        );

        // then
        Assertions.assertThat(underTestAbilities).isEqualTo(expectedAbilities);
    }

    @Test
    void generateAbilities_when_easyMode() {
        // given
        GameMode gameMode = GameMode.EASY;

        Abilities expectedAbilities = new Abilities(
                new Ability(7),
                new Ability(8),
                new Ability(6)
        );

        // when
        Dice strengthDice = new LoadedDice(3); // return 3
        Dice agilityDice = new LoadedDice(4); // return 4
        Dice perceptionDice = new LoadedDice(2); // return 2

        Abilities underTestAbilities = new Abilities(
                Ability.generateAbility(strengthDice, gameMode),
                Ability.generateAbility(agilityDice, gameMode),
                Ability.generateAbility(perceptionDice, gameMode)
        );

        // then
        Assertions.assertThat(underTestAbilities).isEqualTo(expectedAbilities);
    }
}
