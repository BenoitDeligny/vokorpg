package vokorpgback.featureBEFORE.fighting.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vokorpgback.featureBEFORE.fighting.application.FightingUseCase;

@Configuration
public class FightingBean {

    @Bean
    FightingUseCase fightingUseCase() {
        return new FightingUseCase();
    }
}
