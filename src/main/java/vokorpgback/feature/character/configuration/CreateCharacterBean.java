package vokorpgback.feature.character.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vokorpgback.feature.character.application.CreateCharacterUseCase;
import vokorpgback.feature.character.domain.port.CharacterRepository;
import vokorpgback.utils.diceroll.DiceRoll;

@Configuration
public class CreateCharacterBean {
    
     @Bean
     CreateCharacterUseCase createCharacterUseCase(CharacterRepository characterRepository, DiceRoll diceRoll) {
        return new CreateCharacterUseCase(characterRepository, diceRoll);
     }
}
