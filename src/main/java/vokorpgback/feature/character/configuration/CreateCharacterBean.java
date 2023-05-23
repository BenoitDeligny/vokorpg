package vokorpgback.feature.character.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vokorpgback.feature.character.application.CreateCharacterUseCase;
import vokorpgback.feature.character.domain.port.CharacterStorage;

@Configuration
public class CreateCharacterBean {
    
     @Bean
     CreateCharacterUseCase createCharacterUseCase(CharacterStorage characterRepository) {
        return new CreateCharacterUseCase(characterRepository);
     }
}
