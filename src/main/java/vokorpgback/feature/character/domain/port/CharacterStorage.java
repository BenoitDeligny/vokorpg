package vokorpgback.feature.character.domain.port;

import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;

import java.util.List;

public interface CharacterStorage {

    void save(LegendaryCharacter legendaryCharacter);
}
