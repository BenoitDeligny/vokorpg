package vokorpgback.feature.character.exposition.dto;

public class KnowledgeResponseDto {
    private final String name;
    private final int bonus;

    public KnowledgeResponseDto(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }
}
