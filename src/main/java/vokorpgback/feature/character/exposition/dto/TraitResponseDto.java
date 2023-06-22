package vokorpgback.feature.character.exposition.dto;

public class TraitResponseDto {
    private final String type;
    private final int modifier;

    public TraitResponseDto(String type, int modifier) {
        this.type = type;
        this.modifier = modifier;
    }
}
