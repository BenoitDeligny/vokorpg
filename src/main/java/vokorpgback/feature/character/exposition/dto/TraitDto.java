package vokorpgback.feature.character.exposition.dto;

public class TraitDto {
    private final String type;
    private final int modifier;

    public TraitDto(String type, int modifier) {
        this.type = type;
        this.modifier = modifier;
    }
}
