package vokorpgback.feature.character.application;

import vokorpgback.feature.character.domain.port.CharacterStorage;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;

public class CreateCharacterUseCase {

    private final CharacterStorage characterStorage;

    public CreateCharacterUseCase(CharacterStorage characterStorage) {
        this.characterStorage = characterStorage;
    }

    public LegendaryCharacter handle(LegendaryCharacter legendaryCharacter) {
        characterStorage.save(legendaryCharacter);
        return legendaryCharacter;
    }
}
