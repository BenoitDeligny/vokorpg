package vokorpgback.feature.character.exposition.dto;

import java.util.List;

public class ItemDto {
    private final String name;
    private final String type;
    private final TraitDto trait;
    private final String description;

    public ItemDto(String name, String type, TraitDto trait, String description) {
        this.name = name;
        this.type = type;
        this.trait = trait;
        this.description = description;
    }
}
