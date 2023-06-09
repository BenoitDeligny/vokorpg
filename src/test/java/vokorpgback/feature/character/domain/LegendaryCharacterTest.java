package vokorpgback.feature.character.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import vokorpgback.feature.commons.domain.model.LegendaryCharacter;
import vokorpgback.feature.commons.application.LegendaryCharacterFactory;
import vokorpgback.feature.commons.application.DiceFactory;
import vokorpgback.feature.commons.application.OfficialDiceFactory;
import vokorpgback.feature.commons.domain.model.GameMode;

class LegendaryCharacterTest {

    @RepeatedTest(50)
    void generateCharacter_when_normalMode() {
        // given
        GameMode normalMode = GameMode.NORMAL;
        DiceFactory officialDiceFactory = new OfficialDiceFactory();

        // when
        LegendaryCharacter expectedCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(normalMode, officialDiceFactory.createDice(6), "normalCharacter");

        // then
        Assertions.assertThat(expectedCharacter.name()).isEqualTo("normalCharacter");
        Assertions.assertThat(expectedCharacter.age()).isBetween(15, 20);
        Assertions.assertThat(expectedCharacter.strength().value()).isBetween(2, 7);
        Assertions.assertThat(expectedCharacter.agility().value()).isBetween(2, 7);
        Assertions.assertThat(expectedCharacter.perception().value()).isBetween(2, 7);
        Assertions.assertThat(expectedCharacter.totalPower()).isBetween(6, 21);
    }

    @RepeatedTest(50)
    void generateCharacter_when_easyMode() {
        // given
        GameMode easyMode = GameMode.EASY;
        DiceFactory officialDiceFactory = new OfficialDiceFactory();

        // when
        LegendaryCharacter expectedCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(easyMode, officialDiceFactory.createDice(6), "normalCharacter");

        // then
        Assertions.assertThat(expectedCharacter.name()).isEqualTo("normalCharacter");
        Assertions.assertThat(expectedCharacter.age()).isBetween(15, 20);
        Assertions.assertThat(expectedCharacter.strength().value()).isBetween(5, 10);
        Assertions.assertThat(expectedCharacter.agility().value()).isBetween(5, 10);
        Assertions.assertThat(expectedCharacter.perception().value()).isBetween(5, 10);
        Assertions.assertThat(expectedCharacter.totalPower()).isBetween(15, 30);
    }
}
