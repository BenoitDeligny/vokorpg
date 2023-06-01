package vokorpgback.featureBEFORE.character.domain.port;

import vokorpgback.featureBEFORE.character.domain.model.LegendaryCharacter;

public interface CharacterStorage {
    // http://localhost:8080/h2-console
    LegendaryCharacter create(LegendaryCharacter character);

    LegendaryCharacter update(LegendaryCharacter character);
}
