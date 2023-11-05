package vokorpgback.feature.character.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.dice.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacterFactory;

class CreateCharacterUseCaseTest {

    private CreateCharacterUseCase useCase;
    private FakeCharacterStorage storage;

    @BeforeEach
    void setUp() {
        storage = new FakeCharacterStorage();
        useCase = new CreateCharacterUseCase(storage);
    }

    @Test
    void handle_shouldSaveLegendaryCharacter() {
        // given
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, new LoadedDiceFactory(), "Character");

        // when
        useCase.handle(legendaryCharacter);

        // then
        Assertions.assertThat(storage.findAll()).containsExactly(legendaryCharacter);
    }
}