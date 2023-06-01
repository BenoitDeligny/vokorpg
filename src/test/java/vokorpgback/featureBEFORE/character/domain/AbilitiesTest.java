package vokorpgback.featureBEFORE.character.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.character.domain.model.ability.AbilityFactory;
import vokorpgback.feature.commons.application.DiceRoller;
import vokorpgback.feature.commons.application.LoadedDiceRoller;
import vokorpgback.feature.character.domain.model.ability.Abilities;
import vokorpgback.feature.character.domain.model.ability.Ability;
import vokorpgback.feature.commons.domain.model.GameMode;

class AbilitiesTest {

    private DiceRoller diceRoller;
    private AbilityFactory abilityFactory;

    @BeforeEach
    void setUp() {
        diceRoller = new LoadedDiceRoller();
        abilityFactory = new AbilityFactory();
    }

    @Test
    void generateAbilities_when_normalMode() {
        // given
        GameMode gameMode = GameMode.NORMAL;

        diceRoller.createDice(6);
        Ability ability = abilityFactory.generateStrength(diceRoller.rollDice(6), gameMode);

        // when


        // then
        Assertions.assertThat(underTestAbilities).isEqualTo(expectedAbilities);
    }

    @Test
    void generateAbilities_when_easyMode() {
        // given
        GameMode gameMode = GameMode.EASY;

        Abilities expectedAbilities = new Abilities(new Ability(7), new Ability(8), new Ability(6));

        // when
        Abilities underTestAbilities = new Abilities(
                Ability.generateAbility(diceRoller.rollDice(3), gameMode),
                Ability.generateAbility(diceRoller.rollDice(4), gameMode),
                Ability.generateAbility(diceRoller.rollDice(2), gameMode));

        // then
        Assertions.assertThat(underTestAbilities).isEqualTo(expectedAbilities);
    }
}
