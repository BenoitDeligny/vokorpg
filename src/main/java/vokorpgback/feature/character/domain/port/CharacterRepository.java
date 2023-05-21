package vokorpgback.feature.character.domain.port;

import vokorpgback.feature.character.domain.model.Character;

public interface CharacterRepository {
    Character create(Character character);
    Character update(Character character);
}
