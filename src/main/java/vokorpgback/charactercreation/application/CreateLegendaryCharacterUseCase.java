package vokorpgback.charactercreation.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.domain.port.LegendaryCharacterRepository;
import vokorpgback.charactercreation.exposition.dto.LegendaryCharacterDto;

@Service
public class CreateLegendaryCharacterUseCase {

    @Autowired
    private LegendaryCharacterRepository repository;

    public CreateLegendaryCharacterUseCase(LegendaryCharacterRepository legendaryCharacterRepository) {
        this.repository = legendaryCharacterRepository;
    }

    public Optional<LegendaryCharacter> handle(LegendaryCharacterDto dto) {
        return Optional.of(repository.create(toDomain(dto)));
    }

    private LegendaryCharacter toDomain(LegendaryCharacterDto dto) {
        return new LegendaryCharacter(dto.getName());
    }
}
