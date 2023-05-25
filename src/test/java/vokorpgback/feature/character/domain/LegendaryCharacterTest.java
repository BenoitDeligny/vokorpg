package vokorpgback.feature.character.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import vokorpgback.commons.LoadedDice;
import vokorpgback.feature.character.domain.model.Abilities;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.commons.domain.model.GameMode;

import java.lang.reflect.InvocationTargetException;

class LegendaryCharacterTest {
    
    @RepeatedTest(100)
    void generateCharacter_when_normalMode() {
        // given
        GameMode gameMode = GameMode.NORMAL;

        // when
        LegendaryCharacter expectedCharacter = LegendaryCharacter.generateCharacter("Name", gameMode);

        // then
        Assertions.assertThat(expectedCharacter.name()).isEqualTo("Name");
        Assertions.assertThat(expectedCharacter.age()).isBetween(15, 20);
        Assertions.assertThat(expectedCharacter.abilities().strength().value()).isBetween(2, 7);
        Assertions.assertThat(expectedCharacter.abilities().agility().value()).isBetween(2, 7);
        Assertions.assertThat(expectedCharacter.abilities().perception().value()).isBetween(2, 7);
        Assertions.assertThat(expectedCharacter.totalPower()).isBetween(6, 21);
    }
    
    @RepeatedTest(100)
    void generateCharacter_when_easyMode() {
        // given
        GameMode gameMode = GameMode.EASY;

        // when
        LegendaryCharacter expectedCharacter = LegendaryCharacter.generateCharacter("Name", gameMode);

        // then
        Assertions.assertThat(expectedCharacter.name()).isEqualTo("Name");
        Assertions.assertThat(expectedCharacter.age()).isBetween(15, 20);
        Assertions.assertThat(expectedCharacter.abilities().strength().value()).isBetween(5, 10);
        Assertions.assertThat(expectedCharacter.abilities().agility().value()).isBetween(5, 10);
        Assertions.assertThat(expectedCharacter.abilities().perception().value()).isBetween(5, 10);
        Assertions.assertThat(expectedCharacter.totalPower()).isBetween(15, 30);
    }
}
