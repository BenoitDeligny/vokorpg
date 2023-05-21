package vokorpgback.feature.charactercreation.application;

import java.util.ArrayList;
import java.util.List;

import vokorpgback.feature.character.domain.model.Character;
import vokorpgback.feature.character.domain.port.CharacterRepository;

public class InMemoryLegendaryCharacterRepository implements CharacterRepository {

    private List<Character> inMemoryDatabase = new ArrayList<Character>();

    @Override
    public Character create(Character legendaryCharacter) {
        inMemoryDatabase.add(legendaryCharacter);
        return legendaryCharacter;
    }

    public List<Character> getInMemoryDatabase() {
        return inMemoryDatabase;
    }

}
