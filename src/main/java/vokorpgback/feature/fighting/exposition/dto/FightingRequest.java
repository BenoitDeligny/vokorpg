package vokorpgback.feature.fighting.exposition.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class FightingRequest {

  @NotNull(message = "The fighting character should not be null")
  private FightingCharacterDto characterFighter;

  @NotEmpty(message = "The monsters should not be null")
  private List<FightingMonsterDto> monsters;

  public FightingRequest() {}

  public FightingCharacterDto getCharacterFighter() {
    return characterFighter;
  }

  public List<FightingMonsterDto> getMonsters() {
    return monsters;
  }
}
