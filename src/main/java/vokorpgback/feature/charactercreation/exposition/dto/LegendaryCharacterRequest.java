package vokorpgback.feature.charactercreation.exposition.dto;

import jakarta.validation.constraints.NotEmpty;

public class LegendaryCharacterRequest {

    @NotEmpty(message = "Name should not be null")
    private String name;

    public String getName() {
        return name;
    }
  
}
