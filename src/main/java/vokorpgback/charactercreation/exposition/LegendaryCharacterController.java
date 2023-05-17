package vokorpgback.charactercreation.exposition;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vokorpgback.charactercreation.application.CreateLegendaryCharacterUseCase;
import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.exposition.dto.LegendaryCharacterDto;

@RestController
public class LegendaryCharacterController {

    private CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase;
    
    public LegendaryCharacterController(CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase) {
        this.createLegendaryCharacterUseCase = createLegendaryCharacterUseCase;
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<LegendaryCharacter> createLegendaryCharacter(String name) {
        return ResponseEntity.of(createLegendaryCharacterUseCase.handle(toDto(name)));
    }

    private LegendaryCharacterDto toDto(String name) {
        return new LegendaryCharacterDto(name);
    }
}
