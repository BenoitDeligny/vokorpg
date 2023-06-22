package vokorpgback.feature.character.exposition.dto;

import java.util.List;

public class CharacterCreationResponse {
    private final String name;
    private final int age;
    private final int stregnth;
    private final int agility;
    private final int perception;
    private final int fightingMight;
    private final int damageDice;
    private final List<ItemResponseDto> items;
    private final List<PowerResponseDto> powers;
    private final List<KnowledgeResponseDto> knowledge;

    public CharacterCreationResponse(String name, int age, int stregnth, int agility, int perception, int fightingMight, int damageDice, List<ItemResponseDto> items, List<PowerResponseDto> powers, List<KnowledgeResponseDto> knowledge) {
        this.name = name;
        this.age = age;
        this.stregnth = stregnth;
        this.agility = agility;
        this.perception = perception;
        this.fightingMight = fightingMight;
        this.damageDice = damageDice;
        this.items = items;
        this.powers = powers;
        this.knowledge = knowledge;
    }
}
