package vokorpgback.feature.character.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.model.LegendaryCharacterFactory;
import vokorpgback.feature.commons.domain.model.GameMode;
import vokorpgback.feature.commons.domain.model.OfficialDice;

public class CreateCharacterUseCaseTest {

    private CreateCharacterUseCase useCase;

    private InMemoryCharacterRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryCharacterRepository();
        useCase = new CreateCharacterUseCase(repository);
    }

    @Test
    void handle_should_createCharacterInDatabase() {
        // given
        OfficialDice officialDice = new OfficialDice(6);
        LegendaryCharacter legendaryCharacter = LegendaryCharacterFactory.generateLegendaryCharacter(GameMode.NORMAL, officialDice, "myCharacter");

        // when
        LegendaryCharacter characterCreated = useCase.handle(legendaryCharacter);

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(characterCreated);
    }
}
