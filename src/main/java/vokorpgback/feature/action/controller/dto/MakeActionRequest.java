package vokorpgback.feature.action.controller.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotEmpty;
import vokorpgback.feature.commons.domain.model.character.LegendaryCharacter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record MakeActionRequest(
        @NotEmpty(message = "A difficulty should be set.")
        int difficultyThreshold,

        @NotEmpty(message = "You should choose an ability type.")
        AbilityToUseDto abilityToUse,

        KnowledgeToUseDto knowledgeToUse,

        // TODO i shouldn't use a domain object here
        @NotEmpty(message = "A character is needed.")
        LegendaryCharacter legendaryCharacter
) {
}
