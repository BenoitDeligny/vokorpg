package vokorpgback.feature.character.exposition.dto;

public class CharacterCreationResponse {
    private String name;
    private int age;
    private int strength;
    private int agility;
    private int perception;
    
    public CharacterCreationResponse(String name, int age, int strength, int agility, int perception) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.agility = agility;
        this.perception = perception;
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
    
}
