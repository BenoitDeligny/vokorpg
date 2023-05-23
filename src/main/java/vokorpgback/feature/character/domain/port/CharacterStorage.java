package vokorpgback.feature.character.domain.port;

import vokorpgback.feature.character.domain.model.LegendaryCharacter;

public interface CharacterStorage {
    LegendaryCharacter create(LegendaryCharacter character);
    LegendaryCharacter update(LegendaryCharacter character);
}
