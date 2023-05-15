package vokorpgback.characterCreation.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.charactercreation.application.CreateCharacterUseCase;
import vokorpgback.charactercreation.domain.model.Abilities;
import vokorpgback.charactercreation.domain.model.Ability;
import vokorpgback.charactercreation.domain.model.Identity;
import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.exposition.dto.LegendaryCharacterDto;

class CreateCharacterUseCaseTest {

    private StubCharacterCreationStorage storage;

    private CreateCharacterUseCase useCase;

    @BeforeEach
    void setUp() {
        storage = new StubCharacterCreationStorage();
        useCase = new CreateCharacterUseCase(storage);
    }

    @Test
    void handle_should_createLegendaryCharacter() {
        // given
        LegendaryCharacterDto dto = new LegendaryCharacterDto(
            "Billy",
            18,
            5,
            4,
            6
        );

        // when
        LegendaryCharacter expectedLegendaryCharacter = new LegendaryCharacter(
            new Identity(
                "Billy",
                18
            ),
            new Abilities(
                new Ability(5),
                new Ability(4),
                new Ability(6)
            )
        );
        useCase.handle(dto);

        // then
        Assertions.assertThat(storage.getCharacterInMemoryDatabase()).contains(expectedLegendaryCharacter);
    }
}
