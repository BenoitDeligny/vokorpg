package vokorpgback.feature.character.infra;

import org.springframework.stereotype.Repository;
import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.port.CharacterStorage;
import vokorpgback.feature.character.infra.entity.CharacterEntity;

@Repository
public class CharacterJpaStorage implements CharacterStorage {

    private final CharacterRepository jpaRepository;

    public CharacterJpaStorage(CharacterRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public LegendaryCharacter create(LegendaryCharacter character) {
        jpaRepository.save(toEntity(character));
        return character;
    }

    @Override
    public LegendaryCharacter update(LegendaryCharacter character) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    private CharacterEntity toEntity(LegendaryCharacter character) {
        return new CharacterEntity(
                character.name(),
                character.age(),
                character.abilities().strength().value(),
                character.abilities().agility().value(),
                character.abilities().perception().value(),
                character.totalPower());
    }
}
