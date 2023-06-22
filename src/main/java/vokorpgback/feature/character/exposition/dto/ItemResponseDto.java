package vokorpgback.feature.character.exposition.dto;

public class ItemResponseDto {
    private final String name;
    private final String type;
    private final TraitResponseDto trait;
    private final String description;

    public ItemResponseDto(String name, String type, TraitResponseDto trait, String description) {
        this.name = name;
        this.type = type;
        this.trait = trait;
        this.description = description;
    }
}
