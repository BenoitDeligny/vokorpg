package vokorpgback.feature.character.domain.port;

import vokorpgback.feature.character.domain.model.LegendaryCharacter;

import java.lang.reflect.InvocationTargetException;

public interface CharacterStorage {
    LegendaryCharacter create(LegendaryCharacter character);
    LegendaryCharacter update(LegendaryCharacter character);
}
