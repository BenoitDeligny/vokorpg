package vokorpgback.charactercreation.infra;

import org.springframework.stereotype.Repository;

import vokorpgback.charactercreation.domain.model.LegendaryCharacter;
import vokorpgback.charactercreation.domain.port.LegendaryCharacterRepository;

@Repository
public class LegendaryCharacterJpaRepository implements LegendaryCharacterRepository{

    @Override
    public LegendaryCharacter create(LegendaryCharacter legendaryCharacter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    
}
