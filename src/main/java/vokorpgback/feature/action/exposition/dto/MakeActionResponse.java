package vokorpgback.feature.action.exposition.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MakeActionResponse {
    private final boolean isSuccessful;

    public MakeActionResponse(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
}
