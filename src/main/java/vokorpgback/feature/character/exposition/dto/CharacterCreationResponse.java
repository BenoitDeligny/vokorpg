package vokorpgback.feature.character.exposition.dto;

import vokorpgback.feature.commons.domain.model.knowledge.Knowledge;

import java.util.List;

public class CharacterCreationResponse {
    private final String name;
    private final int age;
    private final int stregnth;
    private final int agility;
    private final int perception;
    private final int fightingMight;
    private final int damageDice;
    private final List<ItemDto> items;
    private final List<PowerDto> powers;
    private final List<KnowledgeDto> knowledge;
}
