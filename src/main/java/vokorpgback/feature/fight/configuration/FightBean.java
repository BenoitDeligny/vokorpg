package vokorpgback.feature.fight.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vokorpgback.feature.fight.application.QuickFightUseCase;
import vokorpgback.feature.fight.application.TurnBasedFightUseCase;

@Configuration
public class FightBean {

    @Bean
    QuickFightUseCase quickFightUseCase() {
        return new QuickFightUseCase();
    }

    @Bean
    TurnBasedFightUseCase turnBasedFightUseCase() {
        return new TurnBasedFightUseCase();
    }
}
