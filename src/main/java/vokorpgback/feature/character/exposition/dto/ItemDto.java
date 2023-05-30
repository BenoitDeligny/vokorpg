package vokorpgback.feature.character.exposition.dto;

import java.util.List;

public class ItemDto {
  private String name;
  private String category;
  private List<String> traits;
  private String description;

  public ItemDto(String name, String category, List<String> traits, String description) {
    this.name = name;
    this.category = category;
    this.traits = traits;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

  public List<String> getTraits() {
    return traits;
  }

  public String getDescription() {
    return description;
  }
}
