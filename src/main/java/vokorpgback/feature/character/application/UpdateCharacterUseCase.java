package vokorpgback.feature.character.application;

import vokorpgback.feature.character.domain.model.LegendaryCharacter;
import vokorpgback.feature.character.domain.port.CharacterStorage;
import vokorpgback.utils.diceroll.DiceRoll;

public class UpdateCharacterUseCase {
    
    private CharacterStorage repository;

    private DiceRoll diceRoll;

    public UpdateCharacterUseCase(CharacterStorage repository, DiceRoll diceRoll) {
        this.repository = repository;
        this.diceRoll = diceRoll;
    }
    
    public void handle(LegendaryCharacter character) {
        repository.update(character);
    }
}
