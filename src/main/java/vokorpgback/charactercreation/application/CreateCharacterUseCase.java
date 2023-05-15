package vokorpgback.charactercreation.application;

import org.springframework.stereotype.Service;

import vokorpgback.charactercreation.domain.model.Abilities;
import vokorpgback.charactercreation.domain.model.Ability;
import vokorpgback.charactercreation.domain.model.Identity;
import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.domain.port.CharacterCreationStorage;
import vokorpgback.charactercreation.exposition.dto.LegendaryCharacterDto;

@Service
public class CreateCharacterUseCase {

    private CharacterCreationStorage characterCreationStorage;

    public CreateCharacterUseCase(CharacterCreationStorage characterCreationStorage) {
        this.characterCreationStorage = characterCreationStorage;
    }

    public void handle(LegendaryCharacterDto character) {
        characterCreationStorage.create(toDomain(character));
    }

    private LegendaryCharacter toDomain(LegendaryCharacterDto dto) {
        return new LegendaryCharacter(
                new Identity(
                        dto.getName(),
                        dto.getAge()
                    ),
                new Abilities(
                        new Ability(dto.getPower()),
                        new Ability(dto.getAgility()),
                        new Ability(dto.getPerception())
                    )
        );
    }
}
