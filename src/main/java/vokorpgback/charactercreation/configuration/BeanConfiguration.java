package vokorpgback.charactercreation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vokorpgback.charactercreation.application.CreateLegendaryCharacterUseCase;
import vokorpgback.charactercreation.domain.port.LegendaryCharacterRepository;
import vokorpgback.utils.diceroll.DiceRoll;

@Configuration
public class BeanConfiguration {
    
     @Bean
     CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase(LegendaryCharacterRepository legendaryCharacterRepository, DiceRoll diceRoll) {
        return new CreateLegendaryCharacterUseCase(legendaryCharacterRepository, diceRoll);
     }
}
