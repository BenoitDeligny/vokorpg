package vokorpgback.feature.character.application;

import vokorpgback.feature.character.domain.port.CharacterStorage;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;

import java.util.ArrayList;
import java.util.List;

public class FakeCharacterStorage extends ArrayList<LegendaryCharacter> implements CharacterStorage {
    @Override
    public void save(LegendaryCharacter legendaryCharacter) {
        add(legendaryCharacter);
    }

    public List<LegendaryCharacter> findAll() {
        return this;
    }
}
