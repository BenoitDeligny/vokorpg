package vokorpgback.feature.charactercreation.domain.port;

import vokorpgback.feature.charactercreation.domain.model.LegendaryCharacter;

public interface LegendaryCharacterRepository {
    LegendaryCharacter create(LegendaryCharacter legendaryCharacter);
}
