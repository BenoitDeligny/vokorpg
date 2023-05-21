package vokorpgback.fight.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vokorpgback.fight.application.FightingUseCase;
import vokorpgback.utils.diceroll.DiceRoll;

@Configuration
public class BeanConfiguration {
    
     @Bean
     FightingUseCase fightingUseCase(DiceRoll diceRoll) {
        return new FightingUseCase(diceRoll);
     }
}
