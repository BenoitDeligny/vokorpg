package vokorpgback.charactercreation.exposition;

import org.springframework.stereotype.Controller;

import vokorpgback.charactercreation.application.CreateLegendaryCharacterUseCase;
import vokorpgback.charactercreation.exposition.dto.LegendaryCharacterDto;

@Controller
public class LegendaryCharacterController {

    private CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase;
    
    public LegendaryCharacterController(CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase) {
        this.createLegendaryCharacterUseCase = createLegendaryCharacterUseCase;
    }

    public void createLegendaryCharacter(String name) {
        createLegendaryCharacterUseCase.handle(toDto(name));
    }

    private LegendaryCharacterDto toDto(String name) {
        return new LegendaryCharacterDto(name);
    }
}
