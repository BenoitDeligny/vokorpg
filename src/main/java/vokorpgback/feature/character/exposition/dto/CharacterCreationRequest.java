package vokorpgback.feature.character.exposition.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotEmpty;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CharacterCreationRequest {

    @NotEmpty(message = "A character should have a name.")
    private String name;

    @NotEmpty(message = "You should choose a game difficulty.")
    private String gameMode;

    public String getName() {
        return name;
    }

    public String getGameMode() {
        return gameMode;
    }
}
