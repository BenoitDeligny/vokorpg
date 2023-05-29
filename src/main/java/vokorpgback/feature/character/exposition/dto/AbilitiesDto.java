package vokorpgback.feature.character.exposition.dto;

public class AbilitiesDto {
    private final int strength;
    private final int agility;
    private final int perception;

    public AbilitiesDto(int strength, int agility, int perception) {
        this.strength = strength;
        this.agility = agility;
        this.perception = perception;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getPerception() {
        return perception;
    }
}
