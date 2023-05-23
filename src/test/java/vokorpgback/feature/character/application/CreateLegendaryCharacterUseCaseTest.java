package vokorpgback.feature.character.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import vokorpgback.commons.FakeDiceRollService;
import vokorpgback.feature.character.infra.entity.CharacterEntity;

public class CreateLegendaryCharacterUseCaseTest {

    private CreateCharacterUseCase useCase;

    private InMemoryCharacterRepository repository;
    private FakeDiceRollService fakeDiceRollService;

    @BeforeEach
    void setUp() {
        repository = new InMemoryCharacterRepository();
        fakeDiceRollService = new FakeDiceRollService(1, 5);
        useCase = new CreateCharacterUseCase(repository, fakeDiceRollService);
    }

    @ParameterizedTest(1, 2, 3, 4, 5, 6)
    void handle_should_createCharacterInNormalMode() {
        // given

        // when
        useCase.handle("Name", "normal");

        CharacterEntity expectedCharacter = new CharacterEntity(
                "Name",
                18,
                4,
                5,
                6,
                15);

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(expectedCharacter);
    }

    @Test
    void handle_should_createCharacterInEasyMode() {
        // given

        // when
        useCase.handle("Name", "easy");
        
        CharacterEntity expectedCharacter = new CharacterEntity(
            "Name",
            18,
            7,
            8,
            9,
            24);

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(expectedCharacter);
    }
}
