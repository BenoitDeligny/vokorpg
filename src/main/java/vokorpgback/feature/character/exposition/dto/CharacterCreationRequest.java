package vokorpgback.feature.character.exposition.dto;

import jakarta.validation.constraints.NotEmpty;

public class CharacterCreationRequest {

    @NotEmpty(message = "Name should not be null")
    private String name;

    @NotEmpty(message = "Mode should not be empty")
    private String mode;

    public String getName() {
        return name;
    }

    public String getMode() {
        return mode;
    }
}
