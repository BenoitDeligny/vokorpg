package vokorpgback.feature.fighting.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vokorpgback.feature.fighting.application.FightingUseCase;
import vokorpgback.feature.fighting.application.FleeingUseCase;

@Configuration
public class FleeingBean {

    @Bean
    FleeingUseCase fleeingUseCase() {
        return new FleeingUseCase();
    }
}
