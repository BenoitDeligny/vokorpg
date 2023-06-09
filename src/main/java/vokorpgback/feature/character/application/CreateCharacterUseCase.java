package vokorpgback.feature.character.application;

import vokorpgback.feature.commons.domain.model.LegendaryCharacter;
import vokorpgback.featureBEFORE.character.domain.port.CharacterStorage;

public class CreateCharacterUseCase {

    private final CharacterStorage repository;

    public CreateCharacterUseCase(CharacterStorage repository) {
        this.repository = repository;
    }

    public LegendaryCharacter handle(LegendaryCharacter legendaryCharacter) {
        return repository.create(legendaryCharacter);
    }
}
