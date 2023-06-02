package vokorpgback.featureBEFORE.character.application;

import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.featureBEFORE.character.domain.port.CharacterStorage;
import vokorpgback.feature.commons.domain.model.GameMode;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCharacterRepository implements CharacterStorage {

    private final List<LegendaryCharacter> inMemoryDatabase = new ArrayList<LegendaryCharacter>();

    @Override
    public LegendaryCharacter create(LegendaryCharacter character) {
        inMemoryDatabase.add(character);
        return character;
    }

    @Override
    public LegendaryCharacter update(LegendaryCharacter character) {
        // TODO
        // add logic
        return LegendaryCharacter.generateCharacter("Name", GameMode.NORMAL);
    }

    public List<LegendaryCharacter> getInMemoryDatabase() {
        return inMemoryDatabase;
    }
}
