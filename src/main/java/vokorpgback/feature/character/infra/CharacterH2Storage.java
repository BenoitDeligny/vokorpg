package vokorpgback.feature.character.infra;

import org.springframework.stereotype.Component;
import vokorpgback.feature.character.domain.port.CharacterStorage;
import vokorpgback.feature.character.infra.entity.CharacterEntity;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;

@Component
public class CharacterH2Storage implements CharacterStorage {

    private final CharacterRepository characterRepository;

    public CharacterH2Storage(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public void save(LegendaryCharacter legendaryCharacter) {
        characterRepository.save(toEntity(legendaryCharacter));
    }

    private CharacterEntity toEntity(LegendaryCharacter legendaryCharacter) {
        return new CharacterEntity(
                new CharacterEntity.CharacterIdentity(
                        legendaryCharacter.name(),
                        legendaryCharacter.age()
                ),
                legendaryCharacter.strength(),
                legendaryCharacter.agility(),
                legendaryCharacter.perception(),
                legendaryCharacter.maxNaturalMight(),
                legendaryCharacter.maxTotalMight(),
                legendaryCharacter.remainingMight()
        );
    }
}
