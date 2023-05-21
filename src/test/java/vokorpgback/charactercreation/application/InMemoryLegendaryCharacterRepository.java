package vokorpgback.charactercreation.application;

import java.util.ArrayList;
import java.util.List;

import vokorpgback.feature.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.feature.charactercreation.domain.port.LegendaryCharacterRepository;

public class InMemoryLegendaryCharacterRepository implements LegendaryCharacterRepository {

    private List<LegendaryCharacter> inMemoryDatabase = new ArrayList<LegendaryCharacter>();

    @Override
    public LegendaryCharacter create(LegendaryCharacter legendaryCharacter) {
        inMemoryDatabase.add(legendaryCharacter);
        return legendaryCharacter;
    }

    public List<LegendaryCharacter> getInMemoryDatabase() {
        return inMemoryDatabase;
    }

}
