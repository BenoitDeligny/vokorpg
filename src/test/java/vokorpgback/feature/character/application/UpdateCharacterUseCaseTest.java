package vokorpgback.feature.character.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vokorpgback.commons.FakeDiceRollService;
import vokorpgback.feature.character.domain.model.Abilities;
import vokorpgback.feature.character.domain.model.Ability;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.infra.entity.CharacterEntity;

public class UpdateCharacterUseCaseTest {

    private UpdateCharacterUseCase useCase;

    private InMemoryCharacterRepository repository;
    private FakeDiceRollService fakeDiceRollService;

    @BeforeEach
    void setUp() {
        repository = new InMemoryCharacterRepository();
        fakeDiceRollService = new FakeDiceRollService();
        useCase = new UpdateCharacterUseCase(repository, fakeDiceRollService);
    }

    @Test
    void handle_should_updateCharacter() {
        // given
        LegendaryCharacter actualExistingCharacter = new LegendaryCharacter(
                "Name",
                18,
                new Abilities(
                        new Ability(5),
                        new Ability(5),
                        new Ability(5)),
                15);

        repository.create(actualExistingCharacter);

        // when
        LegendaryCharacter characterToUpdate = new LegendaryCharacter(
                "Name",
                17,
                new Abilities(
                        new Ability(15),
                        new Ability(15),
                        new Ability(15)),
                45);

        useCase.handle(characterToUpdate);

        CharacterEntity expectedCharacter = new CharacterEntity(
                "Name",
                17,
                15,
                15,
                15,
                45);

        // then
        Assertions.assertThat(repository.getInMemoryDatabase()).containsExactly(expectedCharacter);
    }
}
