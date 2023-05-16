package vokorpgback.charactercreation.application;

import org.springframework.stereotype.Service;

import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.domain.port.LegendaryCharacterRepository;
import vokorpgback.charactercreation.exposition.dto.LegendaryCharacterDto;

@Service
public class CreateLegendaryCharacterUseCase {

    private LegendaryCharacterRepository repository;
    
    public CreateLegendaryCharacterUseCase(LegendaryCharacterRepository legendaryCharacterRepository) {
        this.repository = legendaryCharacterRepository;
    }

    public LegendaryCharacter handle(LegendaryCharacterDto dto) {
        return repository.create(toDomain(dto));
    }

    private LegendaryCharacter toDomain(LegendaryCharacterDto dto) {
        return new LegendaryCharacter(dto.getName());
    }
}
