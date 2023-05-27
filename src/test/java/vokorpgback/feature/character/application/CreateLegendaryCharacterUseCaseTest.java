package vokorpgback.feature.character.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.infra.entity.CharacterEntity;
import vokorpgback.feature.commons.domain.model.GameMode;

public class CreateLegendaryCharacterUseCaseTest {

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
        LegendaryCharacter legendaryCharacter = LegendaryCharacter.generateCharacter("Name", GameMode.NORMAL);

        // when
        LegendaryCharacter characterCreated = useCase.handle(legendaryCharacter);
        ;

        CharacterEntity expectedCharacter = new CharacterEntity(
                characterCreated.name(),
                characterCreated.age(),
                characterCreated.abilities().strength().value(),
                characterCreated.abilities().agility().value(),
                characterCreated.abilities().perception().value(),
                characterCreated.totalPower());

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(expectedCharacter);
    }
}
