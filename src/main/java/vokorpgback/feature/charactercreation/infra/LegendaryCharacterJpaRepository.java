package vokorpgback.feature.charactercreation.infra;

import org.springframework.stereotype.Repository;

import vokorpgback.feature.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.feature.charactercreation.domain.port.LegendaryCharacterRepository;

@Repository
public class LegendaryCharacterJpaRepository implements LegendaryCharacterRepository {

    @Override
    public LegendaryCharacter create(LegendaryCharacter legendaryCharacter) {
        return legendaryCharacter;
    }

}
