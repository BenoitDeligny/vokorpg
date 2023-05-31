package vokorpgback.feature.character.exposition.dto;

import java.util.List;

public class GearDto {
    private List<ItemDto> items;

    public GearDto(List<ItemDto> items) {
        this.items = items;
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
