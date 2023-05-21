package vokorpgback.feature.charactercreation.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.feature.character.application.CreateCharacterUseCase;
import vokorpgback.feature.character.domain.model.Abilities;
import vokorpgback.feature.character.domain.model.Ability;
import vokorpgback.feature.character.domain.model.Character;
import vokorpgback.feature.character.infra.entity.CharacterEntity;
import vokorpgback.feature.commons.FakeDiceRollService;

public class CreateLegendaryCharacterUseCaseTest {

    private CreateCharacterUseCase useCase;

    private InMemoryCharacterRepository repository;
    private FakeDiceRollService fakeDiceRollService;

    @BeforeEach
    void setUp() {
        repository = new InMemoryCharacterRepository();
        fakeDiceRollService = new FakeDiceRollService();
        useCase = new CreateCharacterUseCase(repository, fakeDiceRollService);
    }

    @Test
    void handle_should_createLegendaryCharacterInNormalMode() {
        // given
        CharacterEntity expectedCharacter = new CharacterEntity(
                "Name",
                18,
                4,
                6,
                2);

        // when
        useCase.handle("Name", "normal");

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(expectedCharacter);
    }

    @Test
    void handle_should_createLegendaryCharacterInEasyMode() {
        // given
        CharacterEntity expectedCharacter = new CharacterEntity(
                "Name",
                18,
                7,
                9,
                5);

        // when
        useCase.handle("Name", "easy");

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(expectedCharacter);
    }
}
