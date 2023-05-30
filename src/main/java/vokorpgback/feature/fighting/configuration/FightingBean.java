package vokorpgback.feature.fighting.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vokorpgback.feature.fighting.application.FightingUseCase;

@Configuration
public class FightingBean {

  @Bean
  FightingUseCase fightingUseCase() {
    return new FightingUseCase();
  }
}
