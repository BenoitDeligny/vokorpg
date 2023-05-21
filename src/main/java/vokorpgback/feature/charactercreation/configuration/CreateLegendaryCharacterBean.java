package vokorpgback.feature.charactercreation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vokorpgback.feature.charactercreation.application.CreateLegendaryCharacterUseCase;
import vokorpgback.feature.charactercreation.domain.port.LegendaryCharacterRepository;
import vokorpgback.utils.diceroll.DiceRoll;

@Configuration
public class CreateLegendaryCharacterBean {
    
     @Bean
     CreateLegendaryCharacterUseCase createLegendaryCharacterUseCase(LegendaryCharacterRepository legendaryCharacterRepository, DiceRoll diceRoll) {
        return new CreateLegendaryCharacterUseCase(legendaryCharacterRepository, diceRoll);
     }
}
