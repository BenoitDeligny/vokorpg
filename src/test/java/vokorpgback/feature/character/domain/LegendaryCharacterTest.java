package vokorpgback.feature.character.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.model.LegendaryCharacterFactory;
import vokorpgback.feature.commons.application.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.GameMode;

class LegendaryCharacterTest {
    private LegendaryCharacterFactory characterFactory;

    @BeforeEach
    void setUp() {
    characterFactory = new LegendaryCharacterFactory(new LoadedDiceFactory());
    }

    @Test
    void generateCharacter_when_normalMode() {
        // given
        GameMode normalMode = GameMode.NORMAL;

        // when
        LegendaryCharacter expectedCharacter = characterFactory.generateLegendaryCharacter(normalMode, "normalCharacter");

        // then
        Assertions.assertThat(expectedCharacter.name()).isEqualTo("normalCharacter");
        Assertions.assertThat(expectedCharacter.age()).isBetween(15, 20);

        // TODO
        // is it ok ?
        Assertions.assertThat(expectedCharacter.strength().value()).isEqualTo(7);
        Assertions.assertThat(expectedCharacter.agility().value()).isEqualTo(7);
        Assertions.assertThat(expectedCharacter.perception().value()).isEqualTo(7);
        Assertions.assertThat(expectedCharacter.totalPower()).isEqualTo(21);
    }

    @Test
    void generateCharacter_when_easyMode() {
        // given
        GameMode easyMode = GameMode.EASY;

        // when
        LegendaryCharacter expectedCharacter = characterFactory.generateLegendaryCharacter(easyMode, "normalCharacter");

        // then
        Assertions.assertThat(expectedCharacter.name()).isEqualTo("normalCharacter");
        Assertions.assertThat(expectedCharacter.age()).isBetween(15, 20);

        // TODO
        // is it ok ?
        Assertions.assertThat(expectedCharacter.strength().value()).isEqualTo(10);
        Assertions.assertThat(expectedCharacter.agility().value()).isEqualTo(10);
        Assertions.assertThat(expectedCharacter.perception().value()).isEqualTo(10);
        Assertions.assertThat(expectedCharacter.totalPower()).isEqualTo(30);
    }
}
