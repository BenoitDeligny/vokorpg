package vokorpgback.charactercreation.domain.port;
import vokorpgback.charactercreation.domain.model.LegendaryCharacter;

public interface CharacterCreationStorage {

    void create(LegendaryCharacter character);
    
}
