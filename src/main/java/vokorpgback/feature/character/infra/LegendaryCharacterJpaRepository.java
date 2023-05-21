package vokorpgback.feature.character.infra;

import org.springframework.stereotype.Repository;

import vokorpgback.feature.character.domain.model.Character;
import vokorpgback.feature.character.domain.port.CharacterRepository;

@Repository
public class LegendaryCharacterJpaRepository implements CharacterRepository {

    @Override
    public Character create(Character legendaryCharacter) {
        return legendaryCharacter;
    }

}
