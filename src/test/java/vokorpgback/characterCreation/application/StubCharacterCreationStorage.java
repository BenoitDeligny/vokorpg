package vokorpgback.charactercreation.application;

import java.util.ArrayList;
import java.util.List;

import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.domain.port.CharacterCreationStorage;

public class StubCharacterCreationStorage implements CharacterCreationStorage{

    private List<LegendaryCharacter> characterInMemoryDatabase = new ArrayList<LegendaryCharacter>();

    @Override
    public void create(LegendaryCharacter character) {
        characterInMemoryDatabase.add(character);
    }

    public List<LegendaryCharacter> getCharacterInMemoryDatabase() {
        return characterInMemoryDatabase;
    }
    
}
