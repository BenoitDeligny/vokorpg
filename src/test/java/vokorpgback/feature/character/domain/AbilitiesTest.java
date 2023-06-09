package vokorpgback.feature.character.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.ability.Agility;
import vokorpgback.feature.commons.domain.model.ability.Perception;
import vokorpgback.feature.commons.domain.model.ability.Strength;
import vokorpgback.feature.commons.application.DiceFactory;
import vokorpgback.feature.commons.application.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.GameMode;

class AbilitiesTest {

    private DiceFactory loadedDiceFactory;

    @BeforeEach
    void setUp() {
        loadedDiceFactory = new LoadedDiceFactory();
    }

    @Test
    void generateAbilities_when_normalMode() {
        // given

        // when
        Strength strength = AbilityFactory.generateStrength(GameMode.NORMAL, loadedDiceFactory.createDice(4));
        Agility agility = AbilityFactory.generateAgility(GameMode.NORMAL, loadedDiceFactory.createDice(5));
        Perception perception = AbilityFactory.generatePerception(GameMode.NORMAL, loadedDiceFactory.createDice(2));

        // then
        Assertions.assertThat(strength.value()).isEqualTo(5);
        Assertions.assertThat(agility.value()).isEqualTo(6);
        Assertions.assertThat(perception.value()).isEqualTo(3);
    }

    @Test
    void generateAbilities_when_easyMode() {
        // given

        // when
        Strength strength = AbilityFactory.generateStrength(GameMode.EASY, loadedDiceFactory.createDice(4));
        Agility agility = AbilityFactory.generateAgility(GameMode.EASY, loadedDiceFactory.createDice(5));
        Perception perception = AbilityFactory.generatePerception(GameMode.EASY, loadedDiceFactory.createDice(2));

        // then
        Assertions.assertThat(strength.value()).isEqualTo(8);
        Assertions.assertThat(agility.value()).isEqualTo(9);
        Assertions.assertThat(perception.value()).isEqualTo(6);
    }
}
