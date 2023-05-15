package vokorpgback.charactercreation.exposition.dto;

public class LegendaryCharacterDto {
    private String name;
    private int age;
    private int power;
    private int agility;
    private int perception;

    public LegendaryCharacterDto(String name, int age, int power, int agility, int perception) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.agility = agility;
        this.perception = perception;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPower() {
        return power;
    }

    public int getAgility() {
        return agility;
    }

    public int getPerception() {
        return perception;
    }

    
}
