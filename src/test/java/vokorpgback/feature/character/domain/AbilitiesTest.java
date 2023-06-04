package vokorpgback.feature.character.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.character.domain.model.ability.AbilityFactory;
import vokorpgback.feature.character.domain.model.ability.Agility;
import vokorpgback.feature.character.domain.model.ability.Perception;
import vokorpgback.feature.character.domain.model.ability.Strength;
import vokorpgback.feature.commons.application.DiceFactory;
import vokorpgback.feature.commons.application.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.GameMode;

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

        // when
        Strength strength = abilityFactory.generateStrength(diceFactory.rollDice(4));
        Agility agility = abilityFactory.generateAgility(diceFactory.rollDice(5));
        Perception perception = abilityFactory.generatePerception(diceFactory.rollDice(2));

        // then
        Assertions.assertThat(strength.value()).isEqualTo(5);
        Assertions.assertThat(agility.value()).isEqualTo(6);
        Assertions.assertThat(perception.value()).isEqualTo(3);
    }

    @Test
    void generateAbilities_when_easyMode() {
        // given
        abilityFactory = new AbilityFactory(GameMode.EASY);

        // when
        Strength strength = abilityFactory.generateStrength(diceFactory.rollDice(4));
        Agility agility = abilityFactory.generateAgility(diceFactory.rollDice(5));
        Perception perception = abilityFactory.generatePerception(diceFactory.rollDice(2));

        // then
        Assertions.assertThat(strength.value()).isEqualTo(8);
        Assertions.assertThat(agility.value()).isEqualTo(9);
        Assertions.assertThat(perception.value()).isEqualTo(6);
    }
}
