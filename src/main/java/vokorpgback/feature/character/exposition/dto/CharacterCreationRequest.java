package vokorpgback.feature.character.exposition.dto;

import jakarta.validation.constraints.NotEmpty;

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
