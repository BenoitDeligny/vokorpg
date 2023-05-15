package vokorpgback.charactercreation.exposition;

import java.util.Random;

import vokorpgback.charactercreation.application.CreateCharacterUseCase;
import vokorpgback.charactercreation.exposition.dto.LegendaryCharacterDto;

public class LegendaryCharacterController {

    private CreateCharacterUseCase useCase;

    public LegendaryCharacterController(CreateCharacterUseCase useCase) {
        this.useCase = useCase;
    }

    public void createLegendaryCharacter(String name, int age) {
        useCase.handle(toDto(name, age));
    }

    private LegendaryCharacterDto toDto(String name, int age) {
        int roll = new Random().nextInt(6) + 1;

        int power = roll;
        int agility = roll;
        int perception = roll;
        
        return new LegendaryCharacterDto(name, age, power, agility, perception);
    }
}
