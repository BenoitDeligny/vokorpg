package vokorpgback.feature.charactercreation.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.feature.character.application.CreateCharacterUseCase;
import vokorpgback.feature.character.domain.model.Abilities;
import vokorpgback.feature.character.domain.model.Ability;
import vokorpgback.feature.character.domain.model.Character;
import vokorpgback.feature.commons.FakeDiceRollService;

public class CreateLegendaryCharacterUseCaseTest {

    private CreateCharacterUseCase useCase;

    private InMemoryLegendaryCharacterRepository repository;
    private FakeDiceRollService fakeDiceRollService;

    @BeforeEach
    void setUp() {
        repository = new InMemoryLegendaryCharacterRepository();
        fakeDiceRollService = new FakeDiceRollService();
        useCase = new CreateCharacterUseCase(repository, fakeDiceRollService);
    }

    @Test
    void handle_should_createLegendaryCharacterInNormalMode() {
        // given

        // normal mode = FakeDiceRollService values
        Character expectedLegendaryCharacter = new Character(
                "Name",
                18,
                new Abilities(
                        new Ability(4),
                        new Ability(6),
                        new Ability(2)));

        // when
        useCase.handle("Name", "normal");

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(expectedLegendaryCharacter);
    }

    @Test
    void handle_should_createLegendaryCharacterInEasyMode() {
        // given

        // easy mode = FakeDiceRollService values + 3
        Character expectedLegendaryCharacter = new Character(
                "Name",
                18,
                new Abilities(
                        new Ability(7),
                        new Ability(9),
                        new Ability(5)));

        // when
        useCase.handle("Name", "easy");

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(expectedLegendaryCharacter);
    }
}
