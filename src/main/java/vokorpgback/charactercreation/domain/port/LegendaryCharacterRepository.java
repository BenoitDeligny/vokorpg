package vokorpgback.charactercreation.domain.port;

import vokorpgback.charactercreation.domain.model.LegendaryCharacter;

public interface LegendaryCharacterRepository {
    LegendaryCharacter create(LegendaryCharacter legendaryCharacter);
}
