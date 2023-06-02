package vokorpgback.featureBEFORE.character.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.character.domain.model.ability.*;
import vokorpgback.feature.commons.application.DiceFactory;
import vokorpgback.feature.commons.application.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.port.Dice;

class AbilitiesTest {

    private DiceFactory diceFactory;
    private AbilityFactory abilityFactory;

    @BeforeEach
    void setUp() {
        diceFactory = new LoadedDiceFactory();
    }

    @Test
    void generateAbilities_when_normalMode() {
        // given
        abilityFactory = new AbilityFactory(GameMode.NORMAL);
        Dice strengthDice = diceFactory.createDice(4);
        Dice agilityDice = diceFactory.createDice(5);
        Dice perceptionDice = diceFactory.createDice(2);

        // when
        Strength strength = abilityFactory.generateStrength(strengthDice);
        Agility agility = abilityFactory.generateAgility(agilityDice);
        Perception perception = abilityFactory.generatePerception(perceptionDice);

        // then
        Assertions.assertThat(strength.value()).isEqualTo(5);
        Assertions.assertThat(agility.value()).isEqualTo(6);
        Assertions.assertThat(perception.value()).isEqualTo(3);
    }

    @Test
    void generateAbilities_when_easyMode() {
        // given
        abilityFactory = new AbilityFactory(GameMode.EASY);
        Dice strengthDice = diceFactory.createDice(4);
        Dice agilityDice = diceFactory.createDice(5);
        Dice perceptionDice = diceFactory.createDice(2);

        // when
        Strength strength = abilityFactory.generateStrength(strengthDice);
        Agility agility = abilityFactory.generateAgility(agilityDice);
        Perception perception = abilityFactory.generatePerception(perceptionDice);

        // then
        Assertions.assertThat(strength.value()).isEqualTo(8);
        Assertions.assertThat(agility.value()).isEqualTo(9);
        Assertions.assertThat(perception.value()).isEqualTo(6);
    }
}
