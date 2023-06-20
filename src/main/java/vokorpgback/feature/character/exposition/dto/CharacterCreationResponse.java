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

    public CharacterCreationResponse(String name, int age, int stregnth, int agility, int perception, int fightingMight, int damageDice, List<ItemDto> items, List<PowerDto> powers, List<KnowledgeDto> knowledge) {
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
