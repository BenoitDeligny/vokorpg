package vokorpgback.feature.fighting.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vokorpgback.feature.fighting.application.FightingUseCase;
import vokorpgback.utils.diceroll.DiceRoll;

@Configuration
public class FightingBean {
    
     @Bean
     FightingUseCase fightingUseCase(DiceRoll diceRoll) {
        return new FightingUseCase(diceRoll);
     }
}
