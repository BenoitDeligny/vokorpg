package vokorpgback.feature.character.exposition.dto;

public class CharacterCreationResponse {
    private final String name;
    private final int age;
    private final int strength;
    private final int agility;
    private final int perception;
    private final int totalPower;

    public CharacterCreationResponse(String name, int age, int strength, int agility, int perception, int totalPower) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.agility = agility;
        this.perception = perception;
        this.totalPower = totalPower;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
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

    public int getTotalPower() {
        return totalPower;
    }
}
