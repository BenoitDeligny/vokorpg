package vokorpgback.feature.fight.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vokorpgback.feature.character.application.CreateCharacterUseCase;
import vokorpgback.feature.character.domain.port.CharacterStorage;
import vokorpgback.feature.fight.application.FightUseCase;

@Configuration
public class FightBean {

    @Bean
    FightUseCase fightUseCase() {
        return new FightUseCase();
    }
}
