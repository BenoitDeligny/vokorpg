package vokorpgback.charactercreation.application;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.exposition.dto.LegendaryCharacterDto;

public class CreateLegendaryCharacterUseCaseTest {

    private CreateLegendaryCharacterUseCase useCase;

    private InMemoryLegendaryCharacterRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryLegendaryCharacterRepository();
        useCase = new CreateLegendaryCharacterUseCase(repository);
    }

    @Test
    void handle_should_createLegendaryCharacter() {
        // given
        LegendaryCharacterDto dto = new LegendaryCharacterDto("Name");

        // when
        Optional<LegendaryCharacter> expectedLegendaryCharacter = useCase.handle(dto);

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(expectedLegendaryCharacter.get());
    }

    @Test
    void handle_should_mapDtoToDomain() {
        // given
        LegendaryCharacterDto dto = new LegendaryCharacterDto("Name");

        // when
        Optional<LegendaryCharacter> actuaLegendaryCharacter = useCase.handle(dto);

        // then
        LegendaryCharacter expectedLegendaryCharacter = new LegendaryCharacter("Name");
        Assertions.assertThat(expectedLegendaryCharacter.name()).isEqualTo(actuaLegendaryCharacter.get().name());
        // TODO
        // Flaky tests
        // Check how to test random assignment
        Assertions.assertThat(expectedLegendaryCharacter.age()).isBetween(12, 18);
        Assertions.assertThat(expectedLegendaryCharacter.abilities().strength().value()).isBetween(2, 7);
        Assertions.assertThat(expectedLegendaryCharacter.abilities().agility().value()).isBetween(2, 7);
        Assertions.assertThat(expectedLegendaryCharacter.abilities().perception().value()).isBetween(2, 7);
    }
}
