package vokorpgback.feature.character.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.model.LegendaryCharacterFactory;
import vokorpgback.feature.commons.application.DiceFactory;
import vokorpgback.feature.commons.application.LoadedDiceFactory;
import vokorpgback.feature.commons.domain.model.GameMode;

public class CreateCharacterUseCaseTest {
    private LegendaryCharacterFactory legendaryCharacterFactory;

    private CreateCharacterUseCase useCase;

    private InMemoryCharacterRepository repository;

    @BeforeEach
    void setUp() {
        legendaryCharacterFactory = new LegendaryCharacterFactory(new LoadedDiceFactory());
        repository = new InMemoryCharacterRepository();
        useCase = new CreateCharacterUseCase(repository);
    }

    @Test
    void handle_should_createCharacterInDatabase() {
        // given
        LegendaryCharacter legendaryCharacter = legendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, "myCharacter");

        // when
        LegendaryCharacter characterCreated = useCase.handle(legendaryCharacter);

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(characterCreated);
    }
}
