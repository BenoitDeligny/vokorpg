package vokorpgback.feature.character.infra;

import org.springframework.stereotype.Repository;

import vokorpgback.feature.character.domain.model.Character;
import vokorpgback.feature.character.domain.port.CharacterRepository;

@Repository
public class CharacterJpaRepository implements CharacterRepository {

    @Override
    public Character create(Character character) {
        return character;
    }

    @Override
    public Character update(Character character) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
