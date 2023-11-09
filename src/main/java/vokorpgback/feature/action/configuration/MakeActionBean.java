package vokorpgback.feature.action.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vokorpgback.feature.action.application.MakeActionUseCase;

@Configuration
public class MakeActionBean {

    @Bean
    MakeActionUseCase makeActionUseCase() {
        return new MakeActionUseCase();
    }
}
