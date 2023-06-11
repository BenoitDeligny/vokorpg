package vokorpgback.feature.character.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vokorpgback.feature.character.application.CreateCharacterUseCase;

@Configuration
public class CreateCharacterBean {

    @Bean
    CreateCharacterUseCase createCharacterUseCase() {
        return new CreateCharacterUseCase();
    }
}
