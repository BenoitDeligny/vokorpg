package vokorpgback.charactercreation.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.charactercreation.domain.model.Abilities;
import vokorpgback.charactercreation.domain.model.Ability;
import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.commons.FakeDiceRoll;

public class CreateLegendaryCharacterUseCaseTest {

    private CreateLegendaryCharacterUseCase useCase;

    private InMemoryLegendaryCharacterRepository repository;
    private FakeDiceRoll fakeDiceRoll;

    @BeforeEach
    void setUp() {
        repository = new InMemoryLegendaryCharacterRepository();
        fakeDiceRoll = new FakeDiceRoll();
        useCase = new CreateLegendaryCharacterUseCase(repository, fakeDiceRoll);
    }

    @Test
    void handle_should_createLegendaryCharacter() {
        // given
        LegendaryCharacter actualLegendaryCharacter = new LegendaryCharacter(
                "Name",
                18,
                new Abilities(
                        new Ability(4),
                        new Ability(6),
                        new Ability(2)));

        // when
        useCase.handle("Name");

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(actualLegendaryCharacter);
    }
}
